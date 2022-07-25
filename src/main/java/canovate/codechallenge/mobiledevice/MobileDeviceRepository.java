package canovate.codechallenge.mobiledevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice , Long> {

    Optional<MobileDevice>  findMobileDeviceByModel(String model);

    List <MobileDevice> findByModel(String model);

    List <MobileDevice> findByBrand(String brand);

    List<MobileDevice> findByOs(os os);

    List<MobileDevice> findByOsVersion(String osVersion);


}
