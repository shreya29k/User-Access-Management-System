<form action="RequestServlet" method="post">
    <label for="software">Software:</label>
    <select name="software_id" id="software">
        <!-- Populate dynamically -->
    </select>
    <label for="access_type">Access Type:</label>
    <select name="access_type" id="access_type">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <label for="reason">Reason:</label>
    <textarea id="reason" name="reason" required></textarea>
    <button type="submit">Request Access</button>
</form>

