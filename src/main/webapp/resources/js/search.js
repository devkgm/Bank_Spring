
const pager = document.getElementsByClassName("pager");
const frm = document.getElementById("frm");
const pageInput = document.getElementById("page");

for(p of pager){
	p.addEventListener("click", function(e) {
		e.preventDefault();
		const page = this.getAttribute("data-page");
		pageInput.value = page;
		frm.submit();
	})
}	