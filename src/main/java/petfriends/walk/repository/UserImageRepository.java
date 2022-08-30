package petfriends.walk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import petfriends.walk.model.UserImage;

public interface UserImageRepository extends JpaRepository<UserImage, Long> {

}
