package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

public interface StoreService {
   void createRoom(Room room);
	List<Room> getAllRooms(Room room);
	void deleteRoom(int roomNum);
	Room getByroomNumAllRooms(int roomNum);
	void updateRoom(Room updateRoom);
<<<<<<< HEAD
	Store getStoreById(String storeId);
=======
	void CreateStore(Store store);
	Store getStoreById(String storeId);
	List<Room> getRoomsByStoreId(String storeId);
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba

}
//List<Room> getAllRoomsByStoreId(String storeId);