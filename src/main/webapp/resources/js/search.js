
const pager = document.getElementsByClassName("pager");
const frm = document.getElementById("frm");
const pageInput = document.getElementById("page");
const kind = document.getElementById("kind");
const options = document.getElementsByTagName("option");

for(p of pager){
	p.addEventListener("click", function(e) {
		e.preventDefault();
		const page = this.getAttribute("data-page");
		pageInput.value = page;
		frm.submit();
	})
}

for(option of options){
    if(option.value == kind.getAttribute("data-kind")){
        option.selected = true;
    }
}