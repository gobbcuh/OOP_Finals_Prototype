package com.hotel.servlet;

import com.hotel.model.Room;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/main/reserve")
public class ReservationServlet extends HttpServlet {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        rooms.add(new Room(101));
        rooms.add(new Room(102));
        rooms.add(new Room(103));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                selectedRoom = room;
                room.setAvailable(false);
                break;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (selectedRoom != null) {
            out.println("<h1>Reservation confirmed for " + guestName + " in Room " + roomNumber + "</h1>");
        } else {
            out.println("<h1>Room not available!</h1>");
        }
    }
}
