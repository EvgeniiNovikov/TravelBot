package travelBot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travelBot.jpa.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c WHERE c.name = ?1")
    City findCityByName(String name);

    @Query("select c from City c where c.subName = ?1")
    City findCityBySubName(String subName);
}
