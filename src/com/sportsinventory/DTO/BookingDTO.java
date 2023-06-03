package com.sportsinventory.DTO;

public class BookingDTO {
    private int bookingID, userID, itemID;
    private String borrowDate, borrowReturn, status;

    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public String getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    public String getBorrowReturn() {
        return borrowReturn;
    }
    public void setBorrowReturn(String borrowReturn) {
        this.borrowReturn = borrowReturn;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
