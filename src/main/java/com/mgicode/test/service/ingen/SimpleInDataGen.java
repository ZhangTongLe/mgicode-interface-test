package com.mgicode.test.service.ingen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mgicode.test.domain.ApiConfig;
import com.mgicode.test.domain.ApiRequest;
import com.mgicode.test.domain.Asserts;
import com.mgicode.test.domain.InRule;
import com.mgicode.test.rules.InRuleUtils;

/**
 * 只支持一层的输入
 * 
 * @author prk
 *
 */
public class SimpleInDataGen implements IInDataGen {

	@Override
	public List<ApiRequest> gen(Asserts as, ApiConfig apiConfig) {

		if (as.getCount().equals("n")) {
			return genMax(as, apiConfig);
		} else if (as.getCount().equals("1")) {
			return genOne(as, apiConfig);
		} else if (as.getCount().contains("<")) {
			return genLtNum(as, apiConfig);
		}

		else if (as.getCount().contains(">")) {
			return genGtNum(as, apiConfig);
		} else {

			return genEqNum(as, apiConfig);
		}

	}

	public List<ApiRequest> genMax(Asserts as, ApiConfig apiConfig) {
		// 每个assert
		// 排除已经指定数据的字段
		InRuleUtils.loop(apiConfig.getInRule(), (level, name, inrule) -> {
			for (String key : as.getIn().keySet()) {
				if (key.equals(name)) {
					inrule.setExcluded(true);
					break;
				}
			}
			return true;
		});

		// 目前只考虑二层（o数据上只有一层）,即采用form-data的方式进行

		// "in": {
		// "laneEnSeriaNo": "{{user.name}}",
		// "enTime": "322eee"
		// },

		ApiRequest apiRequest = new ApiRequest();
		Map<String, ?> inDataMap = new HashMap<>();

		InRuleUtils.loopBreak(apiConfig.getInRule(), (level, name, inrule) -> {
			// 处理第一层，看看参数是否可以完成为空
			if (level == 0) {
				boolean required = inrule.isRequired();
				//required
				

			} else if (level == 1) {

			}

			return true;

		});

		return null;
	}

	public List<ApiRequest> genOne(Asserts as, ApiConfig apiConfig) {

		if (as.getCount().equals("n")) {

			InRule inRule;
			// as.getIn()
			apiConfig.getInRule();

		}
		return null;
	}

	public List<ApiRequest> genEqNum(Asserts as, ApiConfig apiConfig) {

		if (as.getCount().equals("n")) {

			InRule inRule;
			// as.getIn()
			apiConfig.getInRule();

		}
		return null;
	}

	public List<ApiRequest> genLtNum(Asserts as, ApiConfig apiConfig) {

		if (as.getCount().equals("n")) {

			InRule inRule;
			// as.getIn()
			apiConfig.getInRule();

		}
		return null;
	}

	public List<ApiRequest> genGtNum(Asserts as, ApiConfig apiConfig) {

		if (as.getCount().equals("n")) {

			InRule inRule;
			// as.getIn()
			apiConfig.getInRule();

		}
		return null;
	}
}
