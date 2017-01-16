(function($){
    $.fn.GridTable = {
        initEvent: function(){
            /**
             * 删除一条Emp记录
             */
            $("tbody").delegate("#deleteEmp", "click", function(){
                $.fn.GridTable.method.deleteRow.call(this);
                return false;//使超链接效果失效
            });
            
            /**
             * 点击表格时,出现输入框
             */
            $("tbody").delegate("td:not(.createdate):not(.departmentname):not(:has(a))", "click", function(){
                $.fn.GridTable.method.clickCell.call(this);
            });
            
            /**
             * 当输入框失去焦点时，对数据进行更新
             */
            $("tbody").delegate("td input", "blur", function(){
                $.fn.GridTable.method.updateCell.call(this);
            });
            
            /**
             * 当点击部门栏时，弹出下拉框
             */
            $("tbody").delegate(".departmentname:not(:has(select))", "click", function(){
                $.fn.GridTable.method.showSelect.call(this);
            });
            
            /**
             * 当select失去焦点时，进行跟新操作
             */
            $("tbody").delegate("select", "blur", function(){
                $.fn.GridTable.method.updateDept.call(this);
            });
        },
        method: {
            /**
             * 更新员工的部门信息
             */
            updateDept: function(){
                var $select = $(this);
                var txt = $("select option:selected").text();
                $.post("empUpdateDept", {
                    deptId: $select.val(),
                    id: $select.parent().parent().attr("id"),
                }, function(data){
                    $select.parent().text(txt);
                    $select.remove();
                });
            },
            
            /**
             * 显示下拉框
             */
            showSelect: function(){
                var $td = $(this);
                var txt = $td.text();
                $(this).empty();
                var $selector = $("<select/>").attr("name","department.id");
                $.post("deptlist", {}, function(data){
                    for (var i in data) {
                        var $option;
                        if (txt == data[i].name) {
                            $option = $("<option/>").val(data[i].id).attr("selected", "selected").text(data[i].name);
                        }
                        else {
                            $option = $("<option/>").val(data[i].id).text(data[i].name);
                        }
                        $selector.append($option);
                    }
                    $td.append($selector);
                });
            },
            /**
             * 删除表格行
             */
            deleteRow: function(){
                var del = $(this);
                var id = $(this).parent().parent().attr("id");
                if (window.confirm("您确定删除lastName为’" +
                del.parent().siblings("td:eq(0)").text() +
                "‘记录吗？")) {
                    $.post("empdelete.action", {
                        id: id
                    }, function(data){
                        if (data == "0") {
                            alert("删除失败");
                        }
                        else {
                            alert("删除成功");
                            del.parent().parent().remove();
                        }
                        
                    });
                }
            },
            
            /**
             * 当点击表格列时，表格列出现输入框
             */
            clickCell: function(){
                var $td = $(this);
                var txt = $(this).text();
                var $input = $("<input type='text'/>");
                $(this).empty();
                $(this).append($input);
                $input.focus();
                $($input).val(txt);
            },
            /**
             * 表格更新
             */
            updateCell: function(){
                var $input = $(this);
                var $td = $input.parent();
                var cellValue = $(this).val();
                var cellname = $(this).parent().attr("cellname");
                var id = $(this).parent().parent().attr("id");
                $.post("empupdate.action", {
                    id: id,
                    cellname: cellname,
                    cellValue: cellValue,
                }, function(data){
                    $input.remove();
                    $td.text(cellValue);
                });
            },
        },
    
    };
    
})($);
