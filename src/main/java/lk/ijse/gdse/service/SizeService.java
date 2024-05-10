package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.SizeDTO;
import java.util.List;

/**
 * @author Amil Srinath
 */
public interface SizeService {
    boolean saveSize(SizeDTO sizeDTO);
    boolean deleteSize(String id);
    boolean updateSize(String id, SizeDTO sizeDTO);
    List<SizeDTO> getAllSizes();
    List<String> getItemIds();
}
