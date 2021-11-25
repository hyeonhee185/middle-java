/**
 * 
 */

//게시글 저장
function writeServer(){
	
	$.ajax({
		url : '/board/Write',
		type : 'post',
		data : $('form').serializeArray(),
		success : function(res){
			if(res.sw == 'ok'){
				alert("게시글이 등록되었습니다");
				$('#wModal').modal('hide');
				$(".txt").val("");
			}else{
				alert("게시글 등록에 실패하였습니다");
			}
			//리스트 출력
			listServer(1);
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

//리스트 출력
listServer = function(page){
	$.ajax({
		url : '/board/List',
		type : 'post',
		data : {'page':page},
		success:function(res){
			//BS-collapse_Accordion게시판 형태로 출력
			code = '<div class="panel-group" id="accordion">';
			$.each(res.datas, function(i,v){
				code += '  <div class="panel panel-default">';
				code += '    <div class="panel-heading">';
				code += '      <h4 class="panel-title">';
				code += '        <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.num+'">';
				code +=         v.subject+'</a>';
				code += '      </h4>';
				code += '    </div>';
				code += '    <div id="collapse'+v.num+'" class="panel-collapse collapse">';
				code += '      <div class="panel-body">';
				code += '		 <p class="p1">작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';	
				code += '			조회수 : ' + v.hit + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			날짜 : ' + v.wdate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '		 </p>';
				code += '		 <p class="p2">';
				code += '			<input idx="' + v.num + '" type="button" name="modify" value="수정" class="action">';
				code += '			<input idx="' + v.num + '" type="button" name="delete" value="삭제" class="action">';
				code += '		 </p>';
				code += '		 <p class="p3">' + v.cont + '</p>';
				
				//댓글구간 시작
				code += '<p class="p4">';
				code += '<textarea cols="100"></textarea>';
				code += '<input idx="' + v.num + '" type="button" value="등록" name="reply" class="action">';
				code += '</p>';
				//댓글구간 끝
				
				code += '	   </div>';
				code += '    </div>';
				code += '  </div>';
				code += ' </div>';
			})	
			code += '</div>';
			$('#list').html(code);
			
			//페이지 리스트 - BS_pagination pager 활용
			pager = '<div class="container">';
			//이전버튼(Prev)
			if(res.sp>1){
				pager += '<ul class="pager">';
				pager += '<li><a class="prev" href="#">Prev</a></li></ul>';
			}
			//페이지 번호 출력
			pager += '<ul class="pagination pager">';
			for(i=res.sp; i<=res.ep;i++){
				if(currentPage == i){
					pager += '<li class="active"><a class="paging" href="#">'+ i +'</a></li>';
				}else{
					pager += '<li><a class="paging" href="#">'+ i +'</a></li>';
				}
			}
			pager += '</ul>';
			//다음버튼(Next)
			if(res.ep < res.tp){
				pager += '<ul class="pager">';
				pager += '<li><a class="next" href="#">Next</a></li></ul>';
			}
			pager += '</div>';
			$('#pagelist').html(pager);
		},
		error:function(xhr){
			alert(xhr.status);
		},
		dataType:'json'
	})
}

//댓글 저장
replyServer = function(){
	$.ajax({
		url : '/board/ReplySave',
		type : 'post',
		data : reply,	//객체 - bonum, name, cont 항목이 존재
		success:function(res){
			if(res.sw == 'no'){
				alert("댓글 등록에 실패하였습니다");
				return false;
			}
			//성공시 댓글조회리스트로 이동
			replyListServer();
		},
		error:function(xhr){
			alert(xhr.status);
		},
		dataType: 'json'
	})
}

//댓글리스트 조회
replyListServer = function(){
	$.ajax({
		url : '/board/ReplyList',
		data : {'bonum' : vidx},
		success:function(res){
			
			$.each(res,function(i,v){
				
				code += '<div class="panel-body">';
				code += '  <p class="p1">작성자 : ' + v.name + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';	
				code += '	                       날짜 : ' + v.redate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '  </p>';
				code += '  <p class="p2">';
				code += '	<input idx="' + v.renum + '" type="button" name="r_modify" value="댓글수정" class="action">';
				code += '	<input idx="' + v.renum + '" type="button" name="r_delete" value="댓글삭제" class="action">';
				code += '  </p>';
				code += '<p class="p3">' + v.cont + '</p>';
			})
		},
		error:function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
	

	
	
	
}


