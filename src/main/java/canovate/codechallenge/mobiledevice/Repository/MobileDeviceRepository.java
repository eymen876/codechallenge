package canovate.codechallenge.mobiledevice.Repository;

import canovate.codechallenge.mobiledevice.Enums.os;
import canovate.codechallenge.mobiledevice.Entity.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice , Long> {
    @Query("SELECT d FROM MobileDevice d WHERE (:id is null or d.id = :id) AND (:model is null or d.model = :model) AND" +
            " (:brand is null or d.brand = :brand) AND (:os is null or d.os = :os) AND (:osVersion is null or d.osVersion = :osVersion)")
    List <MobileDevice> search(@Param("id")Long id ,@Param("model")String model,@Param("brand")String brand,
                               @Param("os")os os,@Param("osVersion")String osVersion);


}
