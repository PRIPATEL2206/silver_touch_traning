<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add Sub Category</title>
        <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>

    <body>
        <div class="page">

            <%@ include file="adminSideBar.jsp" %>
                <div class="container card mt-5  px-3 pb-5">
                    <div class="page-wrapper ">
                        <div class="page-header d-print-none">
                            <h2 class="page-title fw-bold">
                                <c:if test="${ area != null }">
                                    Update Sub Category
                                </c:if>
                                <c:if test="${ area == null }">
                                    Add Sub Category
                                </c:if>

                            </h2>
                        </div>
                        <c:if test="${ subCategory != null }">
                            <form action="${subCategory.id}" method="post">
                        </c:if>
                        <c:if test="${ subCategory == null }">
                            <form action="addSubCategory" method="post">
                        </c:if>
                        <div class="mb-3">
                            <label for="category" class="form-label">Select Catgory</label>
                            <select class="form-select" aria-label="Default select example" name="categoryId" required>
                                <c:forEach items="${categories}" var="category">
                                    <c:if test="${ category.id == subCategory.categoryId }">
                                        <option selected value="${category.id}">${category.categoryName}</option>
                                    </c:if>
                                    <c:if test="${ category.id != subCategory.categoryId }">
                                        <option value="${category.id}">${category.categoryName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="subCategoryName" class="form-label">Sub Category Name</label>
                            <input type="text" class="form-control" id="subCategoryName" name="subCategoryName"
                                value="${subCategory.subCategoryName}" required>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Sub Category Discription</label>
                            <textarea name="description" class="form-control" id="description" cols="30" rows="3"
                                required>${subCategory.description}</textarea>
                        </div>
                        <c:if test="${ subCategory != null }">
                            <button type="submit" class="btn btn-primary float-end">update</button>

                        </c:if>
                        <c:if test="${ subCategory == null }">
                            <button type="submit" class="btn btn-primary float-end">Add</button>

                        </c:if>

                        </form>



                    </div>
                </div>
        </div>
    </body>

    </html>