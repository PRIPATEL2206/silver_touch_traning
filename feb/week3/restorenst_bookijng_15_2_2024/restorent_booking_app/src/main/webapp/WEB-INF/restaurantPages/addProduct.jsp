<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add Product</title>
        <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>

    <body>
        <div class="page">

            <%@ include file="restaurantSideBar.jsp" %>
                <div class="container card mt-5  px-3 pb-5">
                    <div class="page-wrapper ">
                        <div class="page-header d-print-none">
                            <h2 class="page-title fw-bold">
                                <c:if test="${ product != null }">
                                    Update Product
                                </c:if>
                                <c:if test="${ product == null }">
                                    Add Product
                                </c:if>

                            </h2>
                        </div>
                        <c:if test="${ product != null }">
                            <form action="${product.id}" method="post" enctype="multipart/form-data">
                        </c:if>
                        <c:if test="${ product == null }">
                            <form action="addProduct" method="post" enctype="multipart/form-data">
                        </c:if>
                        <div class="mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="categoryId" class="form-label">Category Name</label>
                                    <select class="form-select" id="category" aria-label="Default select example"
                                        name="categoryId" required>
                                        <c:forEach items="${categories}" var="category">
                                            <c:if test="${ category.id == product.categoryId }">
                                                <option selected value="${category.id}">${category.categoryName}
                                                </option>
                                            </c:if>
                                            <c:if test="${ category.id != product.categoryId }">
                                                <option value="${category.id}">${category.categoryName}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <label for="subCategoryId" class="form-label">Sub Category Name</label>
                                    <select class="form-select" id="subCategory" aria-label="Default select example"
                                        name="subCategoryId" required>

                                    </select>
                                </div>
                            </div>

                        </div>

                        <div class="mb-3">
                            <label for="productName" class="form-label">Product Name</label>
                            <input type="text" class="form-control" id="productName" name="productName"
                                value="${product.productName}" required>
                        </div>
                        <div class="mb-3">
                            <label for="productPrice" class="form-label">Product Price</label>
                            <input type="number" class="form-control" id="productPrice" name="productPrice"
                                value="${product.productPrice}" required>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Product Description</label>
                            <textarea name="description" class="form-control" id="description" cols="30" rows="3"
                                required>${product.description}</textarea>
                        </div>
                        <div class="mb-3">
                            <label for="produtImage" class="form-label">Product Image</label>
                            <input type="file" class="form-control" id="produtImage" name="image" accept="image/*"
                                value="${product.produtImage}" required>
                        </div>
                        <c:if test="${ product != null }">
                            <button type="submit" class="btn btn-primary float-end">update</button>

                        </c:if>
                        <c:if test="${ product == null }">
                            <button type="submit" class="btn btn-primary float-end">Add</button>

                        </c:if>

                        </form>



                    </div>
                </div>
        </div>
        <script>



            document.getElementById("category").onchange = (e) => {
                subCategory = document.getElementById("subCategory");
                subCategory.innerHTML = "";
                let selected = e.target.value;
                for (let i = 0; i < ALL_SUBCATEGORY.length; i++) {
                    const element = ALL_SUBCATEGORY[i];
                    if (selected == element.cityId) {
                        node = document.createElement("option");
                        node.value = element.id;
                        node.innerText = element.name;
                        subCategory.appendChild(node);
                    }

                }
            };
            const ALL_SUBCATEGORY = [];

            <c:forEach items="${subCategories}" var="subCategory">
                ALL_SUBCATEGORY.push({
                    id : ${subCategory.id},
                name:"${subCategory.subCategoryName}",
                cityId:${subCategory.categoryId}
                });
            </c:forEach>

            let selectedCategory = document.getElementById("category").value;
            let subCategory = document.getElementById("subCategory");
            subCategory.innerHTML = "";
            let selectedSubCategory = 0;
            < c:if test="${ product != null }" >
                selectedSubCategory = ${product.subCategoryId}
            </c:if>
            let selected = selectedCategory
            for (let i = 0; i < ALL_SUBCATEGORY.length; i++) {
                const element = ALL_SUBCATEGORY[i];
                if (selected == element.cityId) {
                    node = document.createElement("option");
                    node.value = element.id;
                    node.selected = element.id == selectedSubCategory
                    node.innerText = element.name;
                    subCategory.appendChild(node);
                }

            }
        </script>
    </body>

    </html>