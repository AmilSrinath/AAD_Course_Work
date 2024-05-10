package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Amil Srinath
 */
public interface SizeDAO extends JpaRepository<Size, String> {
    @Query(value = "SELECT size_id FROM size ORDER BY size_id DESC LIMIT 1", nativeQuery = true)
    String findLastId();

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM size WHERE size = :sizeId AND inventory_item_code = :itemCode", nativeQuery = true)
    Long countBySizeIdAndItemCode(@Param("sizeId") String sizeId, @Param("itemCode") String itemCode);




}
