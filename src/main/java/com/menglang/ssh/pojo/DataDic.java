package com.menglang.ssh.pojo;

public class DataDic {

	private Integer id;
	private String dataDicName;
	private String dataDicValue;

	public DataDic() {
		super();
	}

	public DataDic(Integer id, String dataDicName, String dataDicValue) {
		super();
		this.id = id;
		this.dataDicName = dataDicName;
		this.dataDicValue = dataDicValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataDicName() {
		return dataDicName;
	}

	public void setDataDicName(String dataDicName) {
		this.dataDicName = dataDicName;
	}

	public String getDataDicValue() {
		return dataDicValue;
	}

	public void setDataDicValue(String dataDicValue) {
		this.dataDicValue = dataDicValue;
	}

	@Override
	public String toString() {
		return "DataDic [id=" + id + ", dataDicName=" + dataDicName + ", dataDicValue=" + dataDicValue + "]";
	}

}
