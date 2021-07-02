window.onload = function() {

  	// 学科の選択
	subject = document.getElementById("subject");

  	// ジャンルの選択肢が変更された際の動作
	department = document.getElementById("department");
	
	department.onchange = changeDepartment;
}

// ジャンルの選択肢が変更された際の動作
function changeDepartment() {

  	// 変更後のカテゴリを取得
	var changedDepartment = department.value;

  	if (changedDepartment == "0") {
		// 学部に工学部が選択された場合
		setEngi();
	} else if (changedDepartment == "1") {
		// 学部にシステム理工学部が選択された場合
		setSystem();
	} else if (changedDepartment == "2"){
		// 学部にデザイン工学部が選択された場合
		setDesign();
	} else {
		// 学部に建築学部が選択された時
		setArchi();
	}
}

// 工学部の選択肢を設定する
function setEngi() {
	
	// 学科の選択肢を空にする
	subject.textContent = null;

	// 工学部の選択肢
	var engiSub = [
		{cd:"0", label:"機械工学科"},
		{cd:"1", label:"機械機能工学科"},
		{cd:"2", label:"材料工学科"},
		{cd:"3", label:"応用化学科"},
		{cd:"4", label:"電気工学科"},
		{cd:"5", label:"電子工学科"},
		{cd:"6", label:"情報通信工学科"},
		{cd:"7", label:"情報工学科"},
		{cd:"8", label:"土木工学科"},
		{cd:"9", label:"先進国際課程"}
	];

  	engiSub.forEach(function(value) {
		var op = document.createElement("option");
		op.value = value.cd;
		op.text = value.label;
		subject.appendChild(op);
	});
}

// システム理工学部の選択肢を設定する
function setSystem() {

	// 学科の選択肢を空にする
	subject.textContent = null;

	// システム理工学部の選択肢
	var systemSub = [
		{cd:"10", label:"国際プログラム"},
		{cd:"11", label:"電子情報システム学科"},
		{cd:"12", label:"機械制御システム学科"},
		{cd:"13", label:"環境システム学科"},
		{cd:"14", label:"生命科学科-生命科学コース"},
		{cd:"15", label:"生命科学科-生命医工学コース"},
		{cd:"16", label:"数理科学科"}
	];

  	systemSub.forEach(function(value) {
		var op = document.createElement("option");
		op.value = value.cd;
		op.text = value.label;
		subject.appendChild(op);
	});
}

// デザイン工学部の選択肢を設定する
function setDesign() {

  	// 学科の選択肢を空にする
	subject.textContent = null;

	// デザイン工学部の選択肢
	var designSub = [
		{cd:"17", label:"デザイン工学科 生産・プロダクトデザイン系"},
		{cd:"18", label:"デザイン工学科 ロボティクス・情報デザイン系"}
	];

	designSub.forEach(function(value) {
		var op = document.createElement("option");
		op.value = value.cd;
		op.text = value.label;
		subject.appendChild(op);
	});
}

// 建築学部の選択肢を設定する
function setArchi() {
	
	// 学科の選択肢を空にする
	subject.textContent = null;
	
	// 建築学部の選択肢
	var archiSub = [
		{cd:"19",label:"建築学科"}
	];
	
	archiSub.forEach(function(value) {
		var op = document.creatElement("option");
		op.value = value.cd;
		op.text = value.label;
		subject.appendChild(op);
	});
}











