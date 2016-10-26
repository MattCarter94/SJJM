var fname, lname, gender, email, password, cpassword, housename, street, town, county, postcode, cardname, cardno, validfrom, validto, csv, dispProducts, pFrom;


function _(x){
    return document.getElementById(x);
}

/* $(document).ready(function(){
   $("#userdetails-submit").click(function(){
        fname = _("firstname").value;
        lname = _("surname").value;
        email = _("email").value;
        password = _("password").value;
       cpassword = _("conf-password").value;
       $("#userdetails-form").validate(
      {
        rules: 
        {
          firstname, surname: {required: true, minlength: 5},

                email: { required: true, email: true },
                password: { required:true, password: true },
                cpassword: { required:
           }
        },
        messages: 
        {
          firstname, lastname: 
          {
            required: "Please enter your name"
          },
          email: 
          {
            required: "Please enter your email address."
          },
            password: "Please enter a password"
        }
      });   
    });
    
}); */

function processPhase1(){
    fname = _("firstname").value;
    lname = _("surname").value;
    email = _("email").value;
    password = _("password").value;
    cpassword = _("conf-password").value;
    if(fname.length < 2 && lname.length < 2){
       alert("Error");
    } else {
        _("phase1").style.display = "none";
        _("phase2").style.display = "block";
        _("progressBar").style.width = "66%";
        _("progressBar").innerHTML = "Phase 2 of 3";
    }
}

function processPhase2(){
    housename = _("housename").value;
    street = _("street").value;
    town = _("town").value;
    county = _("county").value;
    postcode = _("postcode").value;

    if(postcode.length > 4){
        _("phase2").style.display = "none";
        _("phase3").style.display = "block";
        _("progressBar").style.width = "100%";
        _("progressBar").innerHTML = "Phase 3 of 3";
    } else {
        alert("Please insert your current address");
    }
}

function backToPhase1(){
    _("phase1").style.display = "block";
    _("phase2").style.display = "none";
    _("progressBar").style.width = "33%";
    _("progressBar").innerHTML = "Phase 1 of 3";
}

function processPhase3(){
    cardname = _("cardname").value;
    cardno = _("cardno").value;
    validfrom = _("validfrom").value;
    validto = _("validto").value;
    csv = _("csv").value;
    if(cardno.length > 15){
        _("phase3").style.display = "none";
        _("show_all_data").style.display = "block";

        _("progressBar").value = 100;
        _("status").innerHTML = "Completed!";
        
        
    } else {
        alert("Please check your card details.");
    }
    
}

function backToPhase2(){
    _("phase2").style.display = "block";
    _("phase3").style.display = "none";
    _("progressBar").style.width = "66%";
    _("progressBar").innerHTML = "Phase 2 of 3";
}




function setSearch() {
    var minField = document.getElementById('price-from'),
        maxField = document.getElementById('price-to'),
		catField = document.getElementById('product-type'),
		itemsToDisplayField = document.getElementById('products');

    var min = minField.options[minField.selectedIndex].value,
        max = maxField.options[maxField.selectedIndex].value,
		cat = catField.options[catField.selectedIndex].value,
		items = itemsToDisplayField.options[itemsToDisplayField.selectedIndex].value;

    // We make sure we have both values and that max is greater than min
    if (min == "" || max == "" || parseInt(max) < parseInt(min)) {
        document.getElementById("shopping-body").innerHTML = "<p>No Results</p>";
        return;
        alert("error 1");
    } else { 
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("shopping-body").innerHTML = this.responseText;
            }
        };

    // Don't forget the '&' to separate the two URL parameters
    xmlhttp.open("GET","searchQuery.php?min=" + min + "&max=" + max + "&cat=" + cat + "&items=" + items, true);
    xmlhttp.send();
		
    }
}

function searchBar(){
    var itemsToDisplayField = document.getElementById('products');
    var items = itemsToDisplayField.options[itemsToDisplayField.selectedIndex].value;
    
    
    var search = document.getElementById('search-term').value;
     if (search == "") {
        document.getElementById("shopping-body").innerHTML = "<p>Please tell us what you're searching for.</p>";
        return;
        alert("error 1");
    } else { 
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("shopping-body").innerHTML = this.responseText;
            }
        };

    // Don't forget the '&' to separate the two URL parameters
    xmlhttp.open("POST","searchQuery.php?search=" + search + "&items=" + items, true);
    xmlhttp.send();
        console.log(items);
    }  
}

function register(){
   var fname = document.getElementById('firstname').value,
       surname = document.getElementById('surname').value,
       email = document.getElementById('email').value,
       password = document.getElementById('password').value;
    if (fname == "") {
        document.getElementById("regdetails").innerHTML = "<p>No Results</p>";
        return;
        alert("error 1");
    } else { 
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
              document.getElementById("regdetails").innerHTML = this.responseText;
            }
        };
    }

    // Don't forget the '&' to separate the two URL parameters
    xmlhttp.open("GET","regQuery.php?fname=" + fname + "&surname=" + surname + "&email=" + email + "&password=" + password, true);
    xmlhttp.send();
}

