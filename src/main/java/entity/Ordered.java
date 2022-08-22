package entity;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;

public class Ordered {
	private int id;
	private String name;
	private String phone;
	private String address;
	private String info;
	
	public Ordered() {
		
	}
	
	public Ordered(int id,String name, String phone, String address, String info) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public List<Product> Convert(){
		List<Product> list = new ArrayList<>();
		String[] products = info.split(" ");
		DAO dao = new DAO();
		for(String p: products) {
			String pId = p.substring(0, 1);
			String number = p.substring(2);
			Product pro = dao.getProduct(pId);
			pro.setNumber(Integer.parseInt(number));
			list.add(pro);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Ordered o = new Ordered();
		DAO dao = new DAO();
		o = dao.getOrdered("9");
		List<Product> list = o.Convert();
		System.out.print(list.get(1).getId());
		System.out.print(list.get(1).getNumber());
	}
}
