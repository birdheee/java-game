package com.game.mapper;

import java.util.List;
import java.util.Map;

public interface BoardInfoMapper {
	List<Map<String, String>> selectBoardInfoList();
}