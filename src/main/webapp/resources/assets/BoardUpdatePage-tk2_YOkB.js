import{u as B,a as C,r as U,c as m,o as n,e as r,f as e,g as i,w as y,v as x,s as M,F as g,q,i as S,t as F}from"./index-gxZJ1D_R.js";import{b as p}from"./boardApi-OemPiS-N.js";const D={class:"mb-3 mt-3 row"},L={class:"col-8"},N={class:"col-4"},R=["value"],E={class:"mb-3 mt-3"},I=["onClick"],P={class:"mb-3 mt-3"},$={class:"mb-3 mt-3"},J={__name:"BoardUpdatePage",setup(h){const u=B(),f=C(),d=u.params.no,s=U({}),c=m([]),o=m({}),b=m(null),v=m([]),T=()=>{f.push({name:"board/detail",params:{no:d},query:u.query})},w=()=>{s.bno=o.value.bno,s.title=o.value.title,s.type=o.value.type,s.writer=o.value.writer,s.content=o.value.content,console.log(s)},V=async(a,t)=>{if(!confirm(t+"을 삭제할까요?"))return;await p.deleteAttachment(a);const l=c.value.findIndex(k=>k.fno===a);c.value.splice(l,1)},A=async()=>{if(!confirm("수정할까요?"))return;b.value.files.length>0&&(s.files=b.value.files),await p.update(s)!=null?(alert("게시글이 수정 되었습니다."),f.push({name:"board/detail",params:{no:d},query:u.query})):(alert("게시글이 수정에 실패 하였습니다."),f.push({name:"board/detail",params:{no:d},query:u.query}))};return(async()=>{const a=await p.get(d);o.value={...a},c.value=a.boardAttachFileList,w()})(),(async()=>{try{v.value=await p.getTypes(),console.log(v.value)}catch{}})(),(a,t)=>(n(),r(g,null,[t[12]||(t[12]=e("h1",null,[e("i",{class:"fa-regular fa-pen-to-square"}),i(" 글 수정")],-1)),e("form",{onSubmit:S(A,["prevent"])},[e("div",D,[e("div",L,[t[3]||(t[3]=e("label",{for:"title",class:"form-label"}," 제목 ",-1)),y(e("input",{type:"text",class:"form-control",placeholder:"제목",id:"title","onUpdate:modelValue":t[0]||(t[0]=l=>s.title=l)},null,512),[[x,s.title]])]),e("div",N,[t[4]||(t[4]=e("label",{for:"title",class:"form-label"}," Type ",-1)),y(e("select",{"onUpdate:modelValue":t[1]||(t[1]=l=>s.type=l),class:"form-select",required:""},[(n(!0),r(g,null,q(v.value,l=>(n(),r("option",{key:l,value:l.type},F(l.name),9,R))),128))],512),[[M,s.type]])])]),e("div",E,[t[6]||(t[6]=e("label",{class:"form-label"}," 기존 첨부파일 ",-1)),(n(!0),r(g,null,q(c.value,l=>(n(),r("div",{key:l.fno,class:"attach"},[t[5]||(t[5]=e("i",{class:"fa-solid fa-paperclip"},null,-1)),i(" "+F(l.originalFilename)+" ",1),e("i",{class:"fa-solid fa-trash-can text-danger ms-2",onClick:k=>V(l.fno,l.originalFilename)},null,8,I)]))),128))]),e("div",P,[t[7]||(t[7]=e("label",{for:"files",class:"form-label"}," 첨부파일 ",-1)),e("input",{type:"file",class:"form-control",placeholder:"첨부파일",id:"files",ref_key:"files",ref:b,multiple:""},null,512)]),e("div",$,[t[8]||(t[8]=e("label",{for:"content",class:"form-label"}," 내용 ",-1)),y(e("textarea",{class:"form-control",placeholder:"내용",id:"content","onUpdate:modelValue":t[2]||(t[2]=l=>s.content=l),rows:"10"},null,512),[[x,s.content]])]),e("div",{class:"my-5 text-center"},[t[11]||(t[11]=e("button",{type:"submit",class:"btn btn-primary me-3"},[e("i",{class:"fa-solid fa-check"}),i(" 확인 ")],-1)),e("button",{type:"button",class:"btn btn-primary me-3",onClick:w},t[9]||(t[9]=[e("i",{class:"fa-solid fa-undo"},null,-1),i(" 취소 ")])),e("button",{class:"btn btn-primary",onClick:T},t[10]||(t[10]=[e("i",{class:"fa-solid fa-arrow-left"},null,-1),i(" 돌아가기 ")]))])],32)],64))}};export{J as default};
