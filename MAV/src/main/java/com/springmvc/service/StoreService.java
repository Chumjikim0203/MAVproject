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
	Store getStoreById(String storeId);

}
//List<Room> getAllRoomsByStoreId(String storeId);