import{a as w,c as m,r as y,o as g,e as I,f as s,g as o,n as x,t as k,w as r,v as i,i as D}from"./index-gxZJ1D_R.js";import{a as p}from"./authApi-CxMn13P0.js";const V={class:"mt-5 mx-auto",style:{width:"500px"}},U={class:"mb-3 mt-3"},B={for:"id",class:"form-label"},E={class:"mb-3 mt-3"},N={class:"mb-3 mt-3"},S={class:"mb-3"},j={class:"mb-3"},C=["disabled"],A={__name:"JoinPage",setup(M){const f=w(),d=m(null),n=m(""),l=y({id:"test",name:"홍길동",email:"hong@gmail.com",password:"1212",password2:"1212",avatar:null}),t=m(!0),c=async()=>{if(!l.id)return alert("사용자 ID를 입력하세요.");t.value=await p.checkId(l.id),console.log(t.value,typeof t.value),n.value=t.value?"이미 사용중인 ID입니다.":"사용가능한 ID입니다."},v=()=>{t.value=!0,l.id?n.value="ID 중복 체크를 하셔야 합니다.":n.value=""},b=async()=>{if(l.password!=l.password2)return alert("비밀번호가 일치하지 않습니다.");d.value.files.length>0&&(l.avatar=d.value.files[0]);try{await p.create(l),f.push({name:"home"})}catch(u){console.error(u)}};return(u,a)=>(g(),I("div",V,[a[13]||(a[13]=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-user-plus"}),o(" 회원 가입 ")],-1)),s("form",{onSubmit:D(b,["prevent"])},[s("div",U,[s("label",B,[a[5]||(a[5]=s("i",{class:"fa-solid fa-user"},null,-1)),a[6]||(a[6]=o(" 사용자 ID : ")),s("button",{type:"button",class:"btn btn-success btn-sm py-0 me-2",onClick:c},"ID 중복 확인"),s("span",{class:x(t.value.value?"text-primary":"text-danger")},k(n.value),3)]),r(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID",id:"id",onInput:v,"onUpdate:modelValue":a[0]||(a[0]=e=>l.id=e)},null,544),[[i,l.id]])]),s("div",null,[a[7]||(a[7]=s("label",{for:"avatar",class:"form-label"},[s("i",{class:"fa-solid fa-user-astronaut"}),o(" 아바타 이미지: ")],-1)),s("input",{type:"file",class:"form-control",ref_key:"avatar",ref:d,id:"avatar",accept:"image/png, image/jpeg"},null,512)]),s("div",E,[a[8]||(a[8]=s("label",{for:"email",class:"form-label"},[s("i",{class:"fa-solid fa-envelope"}),o(" email ")],-1)),r(s("input",{type:"email",class:"form-control",placeholder:"Email",id:"email","onUpdate:modelValue":a[1]||(a[1]=e=>l.email=e)},null,512),[[i,l.email]])]),s("div",N,[a[9]||(a[9]=s("label",{for:"name",class:"form-label"},[s("i",{class:"fa-solid fa-user"}),o(" name ")],-1)),r(s("input",{type:"text",class:"form-control",placeholder:"Name",id:"name","onUpdate:modelValue":a[2]||(a[2]=e=>l.name=e)},null,512),[[i,l.name]])]),s("div",S,[a[10]||(a[10]=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),o(" 비밀번호: ")],-1)),r(s("input",{type:"password",class:"form-control",placeholder:"비밀번호",id:"password","onUpdate:modelValue":a[3]||(a[3]=e=>l.password=e)},null,512),[[i,l.password]])]),s("div",j,[a[11]||(a[11]=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),o(" 비밀번호 확인: ")],-1)),r(s("input",{type:"password",class:"form-control",placeholder:"비밀번호 확인",id:"password2","onUpdate:modelValue":a[4]||(a[4]=e=>l.password2=e)},null,512),[[i,l.password2]])]),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:t.value},a[12]||(a[12]=[s("i",{class:"fa-solid fa-user-plus"},null,-1),o(" 확인 ")]),8,C)],32)]))}};export{A as default};
