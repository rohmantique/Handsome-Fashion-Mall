package com.hyundai.pjt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.hyundai.pjt.dto.ProductDTO;

@Mapper
public interface SearchMapper {
	
	public List<ProductDTO> searchList(String searchText);
}
