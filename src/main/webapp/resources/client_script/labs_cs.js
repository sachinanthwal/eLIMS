var labid;

function loadunit(id)
{
    //alert(id);
    labid = id;
    _("labid").innerHTML = id;
    _("labiddialog").innerHTML = id;

    //Get List of Units for selected Lab.
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "server_script/labs_sc.php",
        data: {reqtype: "LabUnits", id: id},
        success: function (response)
        {   //alert(response[0].roleid); 
            // alert(id);
            var table = document.getElementById("labunits");
            var tr = "<thead><tr><th>Units</th></tr></thead> ";
            for (i = 0; i < response.length; i++)
            {
                var unit = response[i].unitcode;
                tr = tr + "<tr onclick=\"javascript:unituser('" + unit + "');\"><td>" + response[i].unitname + "</td></tr>";
            }
            table.innerHTML = tr;
        },
        error: function (xhr, status, error)
        {
            alert(xhr.responseText);
        }
    });


    $.ajax({
        type: "POST",
        dataType: "json",
        url: "server_script/labs_sc.php",
        data: {reqtype: "lookupUnits", id: id},
        success: function (response)
        {
            var tr = "<thead><tr><th>Units</th></tr></thead> ";
            for (i = 0; i < response.length; i++)
            {
                var unit = response[i].ltext;
                var ucode = response[i].lvalue;
                //tr = tr + "<tr onclick=\"javascript:unituser('" + unit + "');\"><td>" + response[i].unitname + "</td></tr>";
                tr = tr + "<label class='checkbox inline'><input type='checkbox'  name='uu[]' value='" + unit + "-" + ucode + "'>" + unit + "</label><br>";
            }
            tr = tr + "<input type='hidden' name='ID' value='" + id + "'>";
            tr = tr + "<center><button type='submit' class='btn btn-primary' name='updateunit'>Unit Update</button></center>";
            units.innerHTML = tr;
        },
        error: function (xhr, status, error)
        {
            alert(xhr.responseText);
        }
    });
}

function unituser(labunit)
{
    var ulabid = labid;
    var unitcode = labunit;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "server_script/labs_sc.php",
        data: {reqtype: "unitusers", unitcode: unitcode, ulabid: ulabid},
        success: function (response)
        {
            var tr = "<thead><tr><th>Users</th></tr></thead> ";
            for (i = 0; i < response.length; i++)
            {
                tr = tr + "<tr><td>" + response[i].username + "</td></tr>";
            }
            users.innerHTML = tr;

        },
        error: function (xhr, status, error) {
            alert(xhr.responseText);
        }
    });


    $.ajax({
        type: "POST",
        dataType: "json",
        url: "server_script/labs_sc.php",
        data: {reqtype: "unit_users", id: unitcode},
        success: function (response)
        {
            var tr = "<thead><tr><th>Users</th></tr></thead> ";
            for (i = 0; i < response.length; i++)
            {
                var user = response[i].username;
                //tr = tr + "<tr onclick=\"javascript:unituser('" + unit + "');\"><td>" + response[i].unitname + "</td></tr>";
                tr = tr + "<label class='checkbox inline'><input type='checkbox'  name='unitusers[]' value='" + user + "'>" + user + "</label><br>";
            }
            tr = tr + "<input type='hidden' name='unitcode' value='" + unitcode + "'>";
            tr = tr + "<input type='hidden' name='ulabid' value='" + ulabid + "'>";
            tr = tr + "<center><button type='submit' class='btn btn-primary' name='updateuser'>User Update</button></center>";
            unit_user.innerHTML = tr;
        },
        error: function (xhr, status, error)
        {
            alert(xhr.responseText);
        }
    });

}