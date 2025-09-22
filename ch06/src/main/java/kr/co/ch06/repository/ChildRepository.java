package kr.co.ch06.repository;

import kr.co.ch06.Entity.Child;
import kr.co.ch06.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String> {
}
