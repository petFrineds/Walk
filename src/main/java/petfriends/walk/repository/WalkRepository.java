package petfriends.walk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import petfriends.walk.model.Walk;

public interface WalkRepository extends JpaRepository<Walk, Long>{

	// 리스트 조회
    List<Walk> findAllById(Long id);
    
    // 단건 조회
    Optional<Walk> findById(Long id);
    
}