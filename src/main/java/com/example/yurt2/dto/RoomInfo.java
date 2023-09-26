package com.example.yurt2.dto;

import com.example.yurt2.entity.Room;


public class RoomInfo {
    private Room room;
/*
*
* Dormitoryden name bilgisi
* bu bilgiye ulasmak icin:
* adres tablosundaki address id bilgisinden hangi dormitory olduguna ulasabiliriz
*
*/
private String name;

    public long getRoomType() {
        return roomType;
    }

    public long getInstantRoomCapacity() {
        return instantRoomCapacity;
    }

    public long getPrice() {
        return price;
    }

    // buradaki uc bilgi room feature tablosundan
    private long roomType;
    private long instantRoomCapacity;
    private long price;

    public Room getRoom() {
            return room;
    }

    public void setRoom(Room room) {
            this.room = room;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public void setRoomType(int roomType) {
             this.roomType = roomType;
    }
    public long getInstantRoomCapacity(int instantRoomCapacity) {
        return this.instantRoomCapacity;
    }
    public void setInstantRoomCapacity(long instantRoomCapacity) {
        this.instantRoomCapacity = instantRoomCapacity;
    }
    public long getPrice(int price) {
        return this.price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

}
