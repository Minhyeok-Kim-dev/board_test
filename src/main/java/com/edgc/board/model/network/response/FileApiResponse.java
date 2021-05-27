package com.edgc.board.model.network.response;

import java.util.ArrayList;

import com.edgc.board.model.entity.FileEntity;
import com.edgc.common.base.model.network.response.BaseApiResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileApiResponse extends BaseApiResponse {
	private ArrayList<FileEntity> fileList;
}
