package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Room;

public interface StoreRepository {
    
    void createRoom(Room room);
    List<Room> getAllRooms(Room room);
	void deleteRoom(int roomNum);
	Room  getByroomNumAllRooms(int roomNum);
	void updateRoom(Room updateRoom);
}


/*
 * List<Room> getAllRoomsByStoreId(String storeId);
 */	