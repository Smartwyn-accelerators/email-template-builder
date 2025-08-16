package com.fastcode.email.emailbuilder.domain.datasource;

import com.fastcode.email.emailbuilder.application.datasource.dto.PreviewDataSourceOutput;
import org.json.JSONException;

public interface IDataSourceMetaManager {

	public PreviewDataSourceOutput getData(String query) throws JSONException;

}

