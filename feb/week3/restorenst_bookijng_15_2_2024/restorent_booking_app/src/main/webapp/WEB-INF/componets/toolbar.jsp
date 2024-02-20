<div class="d-flax mb-5">
    <button type="button" id="copy" class="btn me-1 btn-secondary">copy</button>
    <button type="button" id="csv" class="btn me-1 btn-info">csv</button>
    <button type="button" id="excel" class="btn me-1 btn-success">Excel</button>
    <button type="button" class="btn me-1 btn-danger">PDF</button>
    <button type="button" id="print" class="btn me-1 btn-primary">Print</button>
</div>



<script>
    document.getElementById("copy").onclick = () => {
        navigator.clipboard.writeText(document.getElementById("table").innerText.trim());
        alert("table is copyed sucessfuly");
    }
    document.getElementById("print").onclick = () => {
        window.print();
    }
</script>

<script>
    csv.onclick = tableToCSV;
    function tableToCSV() {

        let csv_data = [];


        let table = document.getElementById('table');


        let rows = table.getElementsByTagName('tr');
        for (let i = 0; i < rows.length; i++) {


            let cols = rows[i].querySelectorAll('td,th');


            let csvrow = [];
            for (let j = 0; j < cols.length; j++) {


                csvrow.push(cols[j].innerText);
            }


            csv_data.push(csvrow.join(","));
        }


        csv_data = csv_data.join('\n');


        downloadCSVFile(csv_data);
    }

    function downloadCSVFile(csv_data) {

        CSVFile = new Blob([csv_data], {
            type: "text/csv"
        });


        let temp_link = document.createElement('a');


        temp_link.download = "table.csv";
        let url = window.URL.createObjectURL(CSVFile);
        temp_link.href = url;


        temp_link.style.display = "none";
        document.body.appendChild(temp_link);


        temp_link.click();
        document.body.removeChild(temp_link);
    }
</script>

<script>
    excel.onclick = exportToExcel;
    function exportToExcel() {
        var location = 'data:application/vnd.ms-excel;base64,';
        var excelTemplate = '<html> ' +
            '<head> ' +
            '<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/> ' +
            '</head> ' +
            '<body> ' +
            document.getElementById("table").innerHTML +
            '</body> ' +
            '</html>'
        window.location.href = location + window.btoa(excelTemplate);
    }
</script>