package signal.minervini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import signal.minervini.entity.UserEntity;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Modifying
    @Transactional
    @Query("DELETE FROM UserEntity WHERE userName = :userName")
    void deleteByUserName(@Param("userName") String userName);

    @Modifying
    @Transactional
    @Query("SELECT id, userName, role, active FROM UserEntity WHERE userName = :userName")
    User findByUserName(@Param("userName") String userName);

}
