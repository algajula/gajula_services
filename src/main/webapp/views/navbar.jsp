<div class="navbar">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <div class="subnav">
            <button class="subnavbtn">Book <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/bookview">View Books</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/createbook/new">Add Book</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/authorview">Authors</a>
            </div>
        </div>
        <div class="subnav">
            <button class="subnavbtn">Customer <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/customerview">View Customers</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/createcustomer/new">Add Customer</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/vehicleView">Vehicles</a>
            </div>
        </div>
        <div class="subnav">
            <button class="subnavbtn">Users <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/userview">View Users</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/createuser/new">Add User</a>
            </div>
        </div>
        <div class="subnav">
            <button class="subnavbtn">AWS S3 <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/s3fileview/all">S3 Files</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/s3fileupload">Upload File</a>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/">Contact</a>
</div>