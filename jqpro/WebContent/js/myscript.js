/**
 * 
 */

function appendImg(){
	
	//rst1(div)안쪽 첫번째 img를 선택하여 rst1 맨뒤로 추가- 이동됨
	//$('#rst1').append($('#rst1 img').first());
	
	//1초마다 한번씩 자동으로 이동하게 한다
	a = setInterval(function(){
		$('#rst1').append($('#rst1 img').first());
	},500);
	
	//확인 버튼을 감추기
//	$('#btn1').hide();
	//버튼 비활성화
	$('#btn1').prop('disabled',true);
	
}

function stopImg(){
	clearInterval(a);
	$('#btn1').prop('disabled',false);
//	$('#btn1').show();
	
}