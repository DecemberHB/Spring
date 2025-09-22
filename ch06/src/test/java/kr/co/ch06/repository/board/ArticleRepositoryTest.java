package kr.co.ch06.repository.board;

import kr.co.ch06.entity.board.Article;
import kr.co.ch06.entity.board.Comment;
import kr.co.ch06.entity.board.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("게시글 등록 테스트")
    void insertArticleTest(){
        System.out.println("--- 1. 게시글 등록 테스트 시작 ---");
        // given
        // 사용자 정보를 User 엔티티에 맞게 수정
        User user = User.builder()
                .userid("a101")
                .name("김유신")
                .age(23)
                .build();
        System.out.println("--- User 객체 생성: " + user.toString() + " ---");

        // Article을 저장하기 전에 User를 먼저 영속화(저장)
        userRepository.save(user);
        System.out.println("--- User 객체 저장 완료 ---");

        Article article = Article.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .user(user)
                .build();
        System.out.println("--- Article 객체 생성: " + article.toString() + " ---");

        // when
        articleRepository.save(article);
        System.out.println("--- Article 객체 저장 완료 ---");

        // then
        assertNotNull(article.getAno());
        assertThat(article.getTitle()).isEqualTo("테스트 제목");
        assertThat(article.getUser().getUserid()).isEqualTo("a101");
        System.out.println("--- 테스트 성공: Article 등록 및 확인 완료 ---");
    }

    // Comment 엔티티에는 author 필드가 있으므로, 기존 테스트 코드 그대로 유지
    @Test
    @DisplayName("댓글 등록 테스트")
    @Transactional
    @Rollback(false) // 이 어노테이션을 추가하여 테스트 후에도 DB에 데이터가 남도록 설정
    void insertCommentTest(){
        System.out.println("--- 2. 댓글 등록 테스트 시작 ---");
        // given: 댓글 등록을 위해 게시글 먼저 저장
        // Article 엔티티에 'author' 필드가 없으므로, User를 먼저 생성하고 Article에 연결
        User user = User.builder()
                .userid("a101")
                .name("김유신")
                .age(23)
                .build();
        userRepository.save(user);
        System.out.println("--- User 객체 저장 완료: " + user.toString() + " ---");

        Article article = Article.builder()
                .title("댓글 테스트용 게시글")
                .content("댓글 테스트용 게시글 내용")
                .user(user) // author 대신 user 필드 사용
                .build();
        articleRepository.saveAndFlush(article);
        System.out.println("--- Article 객체 저장 완료: " + article.toString() + " ---");

        // when
        Comment comment = Comment.builder()
                .content("테스트 댓글")
                .author("a102")
                .article(article)
                .build();
        System.out.println("--- Comment 객체 생성: " + comment.toString() + " ---");
        commentRepository.save(comment);
        System.out.println("--- Comment 객체 저장 완료 ---");

        // then
        assertNotNull(comment.getCno());
        assertThat(comment.getArticle().getAno()).isEqualTo(article.getAno());
        System.out.println("--- 테스트 성공: Comment 등록 및 확인 완료 ---");
    }
}