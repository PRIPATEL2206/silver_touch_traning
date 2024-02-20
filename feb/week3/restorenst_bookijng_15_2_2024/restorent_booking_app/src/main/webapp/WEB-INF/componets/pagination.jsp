<nav aria-label=" Page navigation example">
    <ul class="pagination mt-3 float-end">
        <!-- <c:if test="${currentPage > 0}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
        </c:if> -->
        <c:forEach begin="0" end="${totalPages - 1}" varStatus="loop">
            <li class="page-item ${loop.index == currentPage ? 'active' : ''}">
                <a class="page-link" href="?page=${loop.index}">${loop.index + 1}</a>
            </li>
        </c:forEach>
        <!-- <c:if test="${currentPage < totalPages - 1}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </c:if> -->

    </ul>
</nav>