package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DemoController {

	@Autowired
	DemoFeignService demoFeignService;

	@Autowired
	CurrencyRepository currencyRepository;
	
	// 查詢單一幣別
	@GetMapping(value = "/currency/query", produces = "application/json;charset=UTF-8")
	public CurrencyRs query(@RequestBody CurrencyRq rqData) {

		CurrencyRs rsData = new CurrencyRs();
		ArrayList<CurrencyEntity> currencyList = new ArrayList<CurrencyEntity>();
		currencyList.add(currencyRepository.findByCode(rqData.getCode()));
		rsData.setCurrencyList(currencyList);

		return rsData;
	}
	
	// 查詢所有幣別
	@GetMapping(value = "/currency/queryAll", produces = "application/json;charset=UTF-8")
	public CurrencyRs queryAll() {

		CurrencyRs rsData = new CurrencyRs();
		List<CurrencyEntity> currencyList = currencyRepository.findAll();
		rsData.setCurrencyList(currencyList);

		return rsData;
	}
	
	// 新增單一幣別
	@PostMapping(value = "/currency/insert", produces = "application/json;charset=UTF-8")
	public String insert(@RequestBody CurrencyRq rqData) {

		CurrencyEntity currencyEntity = new CurrencyEntity();
		currencyEntity.setCode(rqData.getCode());
		currencyEntity.setCodeCH(rqData.getCodeCH());
		currencyEntity.setRate(rqData.getRate());
		currencyEntity.setUpdateTime(String.valueOf(System.currentTimeMillis()));
		currencyRepository.save(currencyEntity);

		return "Update Success";
	}

	// 新增呼叫 coindesk API的幣別
	@PostMapping(value = "/currency/insertFormURL", produces = "application/json;charset=UTF-8")
	public String insertFormURL() throws Exception {

		ObjectMapper objectmapper = new ObjectMapper();
		String json = demoFeignService.getPosts();

		Map map = null;
		CurrencyObject currencyObject = null;

		try {
			map = objectmapper.readValue(json, Map.class);
			currencyObject = objectmapper.convertValue(map, CurrencyObject.class);

		} catch (Exception ex) {
			throw ex;
		}

		CurrencyObBpi currencyObBpi = currencyObject.getCurrencyObBpi();

		String time = getTime(currencyObject.getTime().getUpdatedISO());
		
		String BpiUSD = currencyObBpi.getCurrencyObBpiUSD().getCode();
		String BpiEUR = currencyObBpi.getCurrencyObBpiEUR().getCode();
		String BpiGBP = currencyObBpi.getCurrencyObBpiGBP().getCode();

		insertMap(BpiUSD,getCurrencyCH(BpiUSD), currencyObBpi.getCurrencyObBpiUSD().getRate(), time);
		insertMap(BpiEUR,getCurrencyCH(BpiEUR), currencyObBpi.getCurrencyObBpiEUR().getRate(), time);
		insertMap(BpiGBP,getCurrencyCH(BpiGBP), currencyObBpi.getCurrencyObBpiGBP().getRate(), time);

		return "Insert coindesk Success";
	}

	// 更新單一幣別
	@PostMapping(value = "/currency/update", produces = "application/json;charset=UTF-8")
	public String update(@RequestBody CurrencyRq rqData) {

		CurrencyEntity currencyEntity = new CurrencyEntity();
		currencyEntity.setCode(rqData.getCode());
		currencyEntity.setRate(rqData.getRate());
		currencyEntity.setUpdateTime(String.valueOf(System.currentTimeMillis()));
		currencyRepository.save(currencyEntity);

		return "Update Success";
	}

	// 刪除單一幣別
	@PostMapping(value = "/currency/delete", produces = "application/json;charset=UTF-8")
	public String delete(@RequestBody CurrencyRq rqData) {

		CurrencyEntity currencyEntity = currencyRepository.findByCode(rqData.getCode());
		currencyRepository.delete(currencyEntity);

		return "Delete Success";
	}

	// 取得時間
	private String getTime(String time) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String strTime = time.toString().substring(0, 19).replace("T", " ");
		Date timeconverse = sdf.parse(strTime);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = sdf2.format(timeconverse);

		return str;
	}

	// 存入entity
	private void insertMap(String currency, String currencyCH, String rate, String time) {

		CurrencyEntity currencyEntity = new CurrencyEntity();
		currencyEntity.setCode(currency);
		currencyEntity.setCodeCH(currencyCH);
		currencyEntity.setRate(rate);
		currencyEntity.setUpdateTime(time);
		currencyRepository.save(currencyEntity);
	}
	
	private String getCurrencyCH(String currency){

		String CurrencyCH = null;
		switch(currency) {
			case "USD":
				CurrencyCH = "美金";
				break;
			case "GBP":
				CurrencyCH = "英鎊";
				break;
			case "EUR":
				CurrencyCH = "歐元";
				break;
			case "JPY":
				CurrencyCH = "日元";
				break;
			case "TWD":
				CurrencyCH = "臺幣";
				break;
		}
		return CurrencyCH;
	}
}
