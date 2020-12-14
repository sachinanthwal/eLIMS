$(function () {
    $('#loginform').w2form({ 
        name  : 'form',
        fields: [
            { field: 'username', type: 'text', required: true},
            { field: 'password',  type: 'text', required: true},
            { field: 'site',  type: 'list', required: false,	options: { items: ['Lab1', 'Lab2'] } },
            { field: 'userRole',  type: 'list', required: false,options: { items: ['Admin', 'Analyst','Lab Manager'] } },
        ],
//        onChange: function (event) {
//           if(event.target=='username')
//        	   {
//        	   	var userLoginInfo = fnEventHandler('getUserLoginInfo',JSON.stringify({username: event.value_new}));
//
//        	   //	$('#userrole').w2field('list', { items: userLoginInfo[0] });
//        	   	//var arraySite = userLoginInfo[0];
//          	   	//var arrayRole = userLoginInfo[1];
//        	   }
//        },

        actions: {
            "submit": function()
            {
            $.ajax({
                     url: "/authenticate",
                     data: JSON.stringify({username: "sachin", password: "testuser",userRole: "Admin"}),
                     type: "POST",
                     contentType: "application/json",
                     beforeSend: function(xhr){
                     xhr.setRequestHeader('Authorization', 'test-value');
                     },
                     success: function(data) {


                     }
                  });
            }
        }
    });
});
