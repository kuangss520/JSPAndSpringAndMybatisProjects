package model;

public class TTicket {
    private Integer ticketId;

    private Integer flightId;

    private String seatNumber;

    private String idCard;

    private String status;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber == null ? null : seatNumber.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "TTicket{" +
                "ticketId=" + ticketId +
                ", flightId=" + flightId +
                ", seatNumber='" + seatNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}