package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;
import com.springmvc.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;
    
    
   
    @Override
    public void createRoom(Room room) {
        storeRepository.createRoom(room);
    }
    // 스토어 넘버를 가지고 업데이트라인 뿌리기
    @Override
   public Room getByroomNumAllRooms(int roomNum) {
       
      return storeRepository.getByroomNumAllRooms(roomNum);
   }


    // 전체를 가지고 오는거
   @Override
   public List<Room> getAllRooms(Room room) {
      return storeRepository.getAllRooms(room);
   }

   @Override
   public void deleteRoom(int roomNum) {
      storeRepository.deleteRoom(roomNum);
   }
   @Override
   public void updateRoom(Room updateRoom) {
      storeRepository.updateRoom(updateRoom);
      
   }
   
   //스토어 아이디 가지고 오기
   @Override
   public Store getStoreById(String storeId) {
      // TODO Auto-generated method stub
      return storeRepository.getStoreById(storeId);
   }
   @Override
   public List<Room> getRoomsByStoreId(String storeId) {
      return storeRepository.getRoomsByStoreId(storeId);
   }
   
   @Override
   public void CreateStore(Store store) {
      storeRepository.CreateStore(store);
         
   }
	@Override
	public void UpdateStore(Store store) {
		// TODO Auto-generated method stub
		storeRepository.UpdateStore(store);
	}
	@Override
	public void DeleteStore(String storeId) {
		// TODO Auto-generated method stub
		storeRepository.DeleteStore(storeId);
	}

<<<<<<< HEAD
	@Override
	public void deleteRoom(int roomNum) {
		storeRepository.deleteRoom(roomNum);
	}
	@Override
	public void updateRoom(Room updateRoom) {
		storeRepository.updateRoom(updateRoom);
		
	}
	
	//스토어 아이디 가지고 오기
	@Override
	public Store getStoreById(String storeId) {
		// TODO Auto-generated method stub
		return storeRepository.getStoreById(storeId);
	}
	@Override
	public List<Room> getRoomsByStoreId(String storeId) {
		return storeRepository.getRoomsByStoreId(storeId);
	}
	
	@Override
	public void CreateStore(Store store) {
	   storeRepository.CreateStore(store);
	      
	}
	@Override
	public void updateMatchedValue(int roomNum, int matchedValue) {
		storeRepository.updateMatchedValue(roomNum, matchedValue);	
	}

=======
>>>>>>> origin/PMS
}

