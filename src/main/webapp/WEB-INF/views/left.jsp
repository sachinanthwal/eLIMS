<div class="container-fluid-full">
	<div class="row-fluid">
		<!-- start: Main Menu -->
		<div id="sidebar-left" class="span2">
			<div id="leftmenu" class="nav-collapse sidebar-nav"></div>
		</div>
		<script>
			$(function() {
				var menu = "<ul class='nav nav-tabs nav-stacked main-menu'>";
				$.ajax({
					async: false,
					url : 'getmenugroup',
					success : function(data) {
						
						var grp = JSON.parse(data);
						for (g = 0; g < grp.length; g++) {
							menu +=  "<li><a class='dropmenu' href='#' style='font-weight: 900;' ><i class='icon-eye-open'></i><span class='hidden-tablet' style='margin-left:6px' >" +grp[g]['app_group']+"</span><span class='label labelimportant'></span></a><ul>";
							$.ajax({
								async: false,
								url: 'getmenuitem',
								data: {menugroup: grp[g]['app_group']},
								success: function(data){
									var mitem = JSON.parse(data);
									for(i=0;i<mitem.length;i++){
										menu+=  "<li><a class ='submenu' href ='" +mitem[i]['url']+"' target='appContent'><i class ='icon-file-alt'></i><span class ='hidden-tablet'>" +mitem[i]['caption']+ "</span></a></li>";

										}
									menu+="</ul></li>";
									}
								});		
						}
					}
				});
				$('#leftmenu').html(menu+"</ul>");
			});
		</script>