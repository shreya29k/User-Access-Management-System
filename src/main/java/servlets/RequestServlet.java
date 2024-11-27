@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int softwareId = Integer.parseInt(request.getParameter("software_id"));
        String accessType = request.getParameter("access_type");
        String reason = request.getParameter("reason");

        try (Connection conn = DatabaseConnection.initializeDatabase();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO requests (user_id, software_id, access_type, reason) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, userId);
            stmt.setInt(2, softwareId);
            stmt.setString(3, accessType);
            stmt.setString(4, reason);
            stmt.executeUpdate();
            response.sendRedirect("requestAccess.jsp?success=1");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error submitting request.");
        }
    }
}

