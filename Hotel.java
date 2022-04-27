package starter;
import java.util.*;

public class Hotel {
	private String name,address;
	RoomsManagement availability;
	BillGenerator bill;
	ExtraAmenity extraaminity;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void ShowHotelDetails() {
		System.out.println(this.getName());
		System.out.println(this.getAddress());
	}
	ArrayList<Room> rooms=new ArrayList<>();
	int GetTotalRooms() {
		return RoomsManagement.getTotalEconomyRoom()+RoomsManagement.getTotalStandardRoom()+RoomsManagement.getTotalPremiumRoom();
	}
	void AddRoomAvailabilityClass(RoomsManagement availability) {
		this. availability= availability;
		availability.ResetRoomAvailability();
	}
	void AddExtraAminityClass(ExtraAmenity extraaminity) {
		this.extraaminity=extraaminity;
		extraaminity.AddBasicExtraAminity();
	}
	void AddRoomTypes(Room e) {
		rooms.add(e);
		e.AddBasicAminitys();
	}
	void ShowRoomDetails() {
		for(Room obj:rooms) {
			System.out.print(obj.getName()+" Price:"+obj.getPrice()+" Availability:");
			if(obj.getName()=="Economy Room") {
				System.out.print(availability.GetEconomyRoomsVacant()+"\n");
			}else if(obj.getName()=="Standard Room") {
				System.out.print(availability.GetStandardRoomsVacant()+"\n");
			}else if(obj.getName()=="Premium Room") {
				System.out.print(availability.GetPremiumRoomsVacant()+"\n");
			}
		}
	}
	void ShowBill(BillGenerator bill) {
		this.bill=bill;
		HashMap<String,ArrayList<Integer>> payslip=bill.getBill();
		for (String obj:payslip.keySet()) {
			ArrayList<Integer> list=payslip.get(obj);
			System.out.println(obj+" -> "+list.get(0)+" - "+list.get(1)+" - "+list.get(2));
		}
	}
}
class RoomsManagement {
	static private int totalPremiumRoom=25,totalStandardRoom=50,totalEconomyRoom=75;
	static private ArrayList<Integer> premiumCustomerRoom = new ArrayList<>(totalPremiumRoom);
	static private ArrayList<Integer> standardCustomerRoom = new ArrayList<>(totalStandardRoom);
	static private ArrayList<Integer> economyCustomerRoom = new ArrayList<>(totalEconomyRoom);
	public void ResetRoomAvailability() {
		for(int i=0;i<totalPremiumRoom;i++) {
			premiumCustomerRoom.add(0);
		}
		for(int i=0;i<totalStandardRoom;i++) {
			standardCustomerRoom.add(0);
		}
		for(int i=0;i<totalEconomyRoom;i++) {
			economyCustomerRoom.add(0);
		}
	}
	public String CheckInPremiumRooms(int customerID) {
		int i;
		for (i=0;i<totalPremiumRoom;i++) {
			if (premiumCustomerRoom.get(i)==0) {
				premiumCustomerRoom.set(i,customerID);
				break;
			}
		}
		return "P"+String.valueOf(i); 
	}
	public String CheckInStandardRooms(int customerID) {
		int i;
		for (i=0;i<totalStandardRoom;i++) {
			if (standardCustomerRoom.get(i)==0) {
				standardCustomerRoom.set(i,customerID);
				break;
			}
		}return "S"+String.valueOf(i); 
	}
	public String CheckInEconomyRooms(int customerID) {
		int i;
		for (i=0;i<totalEconomyRoom;i++) {
			if (economyCustomerRoom.get(i)==0) {
				economyCustomerRoom.set(i,customerID);
				break;
			}
		}return "E"+String.valueOf(i); 
	}
	public void CheckOutPremiumRooms(String roomNo) {
		
		premiumCustomerRoom.set(Integer.parseInt(roomNo.substring(1,roomNo.length())), 0);
	}
	public void CheckOutStandardRooms(String roomNo) {
		standardCustomerRoom.set(Integer.parseInt(roomNo.substring(1,roomNo.length())), 0);
	}
	public void CheckOutEconomyRooms(String roomNo) {
		economyCustomerRoom.set(Integer.parseInt(roomNo.substring(1,roomNo.length())), 0);
	}
	public int GetPremiumRoomsVacant() {
		int count=0;
		for (int i:premiumCustomerRoom) {
			if(i==0) {
				count+=1;
			}
		}
		return count;
	}
	public int GetStandardRoomsVacant() {
		int count=0;
		for (int i:standardCustomerRoom) {
			if(i==0) {
				count+=1;
			}
		}
		return count;
	}
	public int GetEconomyRoomsVacant() {
		int count=0;
		for (int i:economyCustomerRoom) {
			if(i==0) {
				count+=1;
			}
		}
		return count;
	}
	public static int getTotalEconomyRoom() {
		return totalEconomyRoom;
	}
	public static void setTotalEconomyRoom(int totalEconomyRoom) {
		RoomsManagement.totalEconomyRoom = totalEconomyRoom;
	}
	public static int getTotalPremiumRoom() {
		return totalPremiumRoom;
	}
	public static void setTotalPremiumRoom(int totalPremiumRoom) {
		RoomsManagement.totalPremiumRoom = totalPremiumRoom;
	}
	public static int getTotalStandardRoom() {
		return totalStandardRoom;
	}
	public static void setTotalStandardRoom(int totalStandardRoom) {
		RoomsManagement.totalStandardRoom = totalStandardRoom;
	}	
}
interface Room{
	public int getPrice();
	public void setPrice(int price) ;
	void AddBasicAminitys();
	void AddAminity(String aminity,int nO);
	void ShowAminity() ;
	String getRoomNo();
	void setName(String name);
	String getName();
	void setRoomNo(String roomNo);
}
class EconomyRoom implements Room{
	private static int price=50;
	private String name="Economy Room",roomNo;
	HashMap<String,Integer> aminitys=new HashMap<>();
	public void AddBasicAminitys() {
		aminitys.put("Single Bed",1);
		aminitys.put("Fan",1);
		aminitys.put("Wifi",1);
		aminitys.put("Pillow",1);
		aminitys.put("Bed Sheet",1);
		aminitys.put("Wardrobe",1);
	}
	public void AddAminity(String aminity,int nO) {
		aminitys.put(aminity,nO);
	}
	public void ShowAminity() {
		for(String aminity:aminitys.keySet()) {
			System.out.println(aminity);
		}
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public void setPrice(int price) {
		EconomyRoom.price=price;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo=roomNo;
	}
}
class StandardRooms implements Room{
	private static int price=75;
	private String name="Standard Room",roomNo;
	HashMap<String,Integer> aminitys=new HashMap<>();
	public void AddBasicAminitys() {
		aminitys.put("Double Bed",1);
		aminitys.put("Fan",2);
		aminitys.put("Wifi",1);
		aminitys.put("Pillow",2);
		aminitys.put("Bed Sheet",2);
		aminitys.put("Wardrobe",2);
		aminitys.put("Waterheater",1);
		aminitys.put("AC",1);
		aminitys.put("TV",1);
		aminitys.put("NightLamp",1);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		StandardRooms.price = price;
	}
	public void AddAminity(String aminity,int nO) {
		aminitys.put(aminity,nO);
	}
	public void ShowAminity() {
		for(String aminity:aminitys.keySet()) {
			System.out.println(aminity);
		}
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void setRoomNo(String roomNo) {
		this.roomNo=roomNo;		
	}
}
class PremiumRooms implements Room{
	private static int price=100;
	private String name="Premium Room",roomNo;
	HashMap<String,Integer> aminitys=new HashMap<>();
	public void AddBasicAminitys() {
		aminitys.put("Triple Bed",1);
		aminitys.put("Fan",3);
		aminitys.put("Wifi",1);
		aminitys.put("Pillow",3);
		aminitys.put("Bed Sheet",3);
		aminitys.put("Wardrobe",3);
		aminitys.put("Private Swimming Pool",1);
		aminitys.put("WaterHeater",1);
		aminitys.put("AC",2);
		aminitys.put("Bathtub",1);
		aminitys.put("Fridge",1);
		aminitys.put("Tv",2);
		aminitys.put("NightLamp",1);
	}	
	public void AddAminity(String aminity,int nO) {
		if(aminitys.containsKey(aminity)) {
			nO+=aminitys.get(aminity);
		}
		aminitys.put(aminity,nO);
	}
	public void ShowAminity() {
		for(String aminity:aminitys.keySet()) {
			System.out.println(aminity);
		}
	}
	public String getRoomNo() {
		return roomNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public void setPrice(int price) {
		PremiumRooms.price=price;
	}
	@Override
	public void setRoomNo(String roomNo) {
		this.roomNo=roomNo;		
	}
}
class Booking{
	Room room;
	RoomsManagement roomManagement;
	BillGenerator bill;
	private String customerName;
	private int customerID;
	private Date checkIn,checkOut;
	private int price=0,days=0;
	void AddRoomClass(Room room) {
		this.room=room;
	}
	void AddRoomsManagementClass(RoomsManagement roomManagement) {
		this.roomManagement=roomManagement;
	}
	void AddBillGeneratorClass(BillGenerator bill) {
		this.bill=bill;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
		this.CalculateDaysStayed(checkIn, checkOut);
		this.CalculatePrice();
		bill.AddToBill(room.getName(), days, room.getPrice(), price);
		if(room.getName()=="Economy Room") {
			roomManagement.CheckOutEconomyRooms(room.getRoomNo());
		}else if(room.getName()=="Standard Room") {
			roomManagement.CheckOutStandardRooms(room.getRoomNo());;
		}else if(room.getName()=="Premium Room") {
			roomManagement.CheckOutPremiumRooms(room.getRoomNo());;
		}
	}
	public int getPrice() {
		this.CalculatePrice();
		return price;
		
	}
	public void CalculateDaysStayed(Date date1,Date date2) {
		long date1InMs = date1.getTime();
		long date2InMs = date2.getTime();
		long timeDiff = 0;
		if(date1InMs > date2InMs) {
			timeDiff = date1InMs - date2InMs;
		} else {
			timeDiff = date2InMs - date1InMs;
		}
		this.days = (int) (timeDiff / (1000 * 60 * 60* 24));
	}
	public int getDays() {
		return days;
	}
	public void CalculatePrice() {
		price=room.getPrice()*days;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
		if(room.getName()=="Economy Room") {
			room.setRoomNo(roomManagement.CheckInEconomyRooms(customerID));
		}else if(room.getName()=="Standard Room") {
			room.setRoomNo(roomManagement.CheckInStandardRooms(customerID));
		}else if(room.getName()=="Premium Room") {
			room.setRoomNo(roomManagement.CheckInPremiumRooms(customerID));
		}
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
class ExtraAmenity{
	private int price=0;
	BillGenerator bill;
	Booking days;
	Room room;
	void AddBillClass(BillGenerator bill) {
		this.bill=bill;
	}
	void AddDays(Booking days) {
		this.days=days;
	}
	void AddRoomClass(Room room){
		this.room=room;
	}
	HashMap<String,Integer> extraAminity =new HashMap<>();
	void AddBasicExtraAminity() {
		extraAminity.put("fan",1);
		extraAminity.put("ac",2);
		extraAminity.put("mattress",3);
		extraAminity.put("pillow",4);
		extraAminity.put("bedSheet",5);
		extraAminity.put("waterHeater",6);
		extraAminity.put("inductionStove",7);
		extraAminity.put("ironbox",8);
	}
	public void ShowExtraAminity() {
		for(String a: extraAminity.keySet()){
            System.out.println(a+" price:"+extraAminity.get(a));
        }
	}
	void AddExtraAminity(String name,int price) {
		extraAminity.put(name, price);
	}
	void BuyExtraAminity(String name,int nO) {
		int price=extraAminity.get(name);
		this.price+=price*nO*days.getDays();
		bill.AddToBill(name, nO, price, nO*price*days.getDays());
		room.AddAminity(name, nO);
	}
	int getPrice() {
		return price;
	}
}
class BillGenerator{
	HashMap<String,ArrayList<Integer>> bill=new HashMap<>();
	void AddToBill(String name,int nO,int price,int totalPrice) {
		if(bill.containsKey(name)) {
			ArrayList<Integer> templist = bill.get(name);
			nO+=templist.get(0);
			totalPrice+=templist.get(2);
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(nO);
		list.add(price);
		list.add(totalPrice);
		bill.put(name, list);
	}
	HashMap<String,ArrayList<Integer>> getBill(){
		return bill;
	}
}