import{C as mr,b as gr,D as Lr}from"./index-tRvG9TKO.js";var Ke=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};function Gr(r){return r&&r.__esModule&&Object.prototype.hasOwnProperty.call(r,"default")?r.default:r}function kr(r){if(r.__esModule)return r;var e=r.default;if(typeof e=="function"){var t=function n(){return this instanceof n?Reflect.construct(e,arguments,this.constructor):e.apply(this,arguments)};t.prototype=e.prototype}else t={};return Object.defineProperty(t,"__esModule",{value:!0}),Object.keys(r).forEach(function(n){var o=Object.getOwnPropertyDescriptor(r,n);Object.defineProperty(t,n,o.get?o:{enumerable:!0,get:function(){return r[n]}})}),t}var zr=Error,qr=EvalError,Hr=RangeError,Kr=ReferenceError,hr=SyntaxError,ae=TypeError,Qr=URIError,Vr=function(){if(typeof Symbol!="function"||typeof Object.getOwnPropertySymbols!="function")return!1;if(typeof Symbol.iterator=="symbol")return!0;var e={},t=Symbol("test"),n=Object(t);if(typeof t=="string"||Object.prototype.toString.call(t)!=="[object Symbol]"||Object.prototype.toString.call(n)!=="[object Symbol]")return!1;var o=42;e[t]=o;for(t in e)return!1;if(typeof Object.keys=="function"&&Object.keys(e).length!==0||typeof Object.getOwnPropertyNames=="function"&&Object.getOwnPropertyNames(e).length!==0)return!1;var a=Object.getOwnPropertySymbols(e);if(a.length!==1||a[0]!==t||!Object.prototype.propertyIsEnumerable.call(e,t))return!1;if(typeof Object.getOwnPropertyDescriptor=="function"){var i=Object.getOwnPropertyDescriptor(e,t);if(i.value!==o||i.enumerable!==!0)return!1}return!0},Qe=typeof Symbol<"u"&&Symbol,Jr=Vr,jr=function(){return typeof Qe!="function"||typeof Symbol!="function"||typeof Qe("foo")!="symbol"||typeof Symbol("bar")!="symbol"?!1:Jr()},be={__proto__:null,foo:{}},Yr=Object,Xr=function(){return{__proto__:be}.foo===be.foo&&!(be instanceof Yr)},Zr="Function.prototype.bind called on incompatible ",et=Object.prototype.toString,rt=Math.max,tt="[object Function]",Ve=function(e,t){for(var n=[],o=0;o<e.length;o+=1)n[o]=e[o];for(var a=0;a<t.length;a+=1)n[a+e.length]=t[a];return n},nt=function(e,t){for(var n=[],o=t,a=0;o<e.length;o+=1,a+=1)n[a]=e[o];return n},at=function(r,e){for(var t="",n=0;n<r.length;n+=1)t+=r[n],n+1<r.length&&(t+=e);return t},ot=function(e){var t=this;if(typeof t!="function"||et.apply(t)!==tt)throw new TypeError(Zr+t);for(var n=nt(arguments,1),o,a=function(){if(this instanceof o){var c=t.apply(this,Ve(n,arguments));return Object(c)===c?c:this}return t.apply(e,Ve(n,arguments))},i=rt(0,t.length-n.length),f=[],l=0;l<i;l++)f[l]="$"+l;if(o=Function("binder","return function ("+at(f,",")+"){ return binder.apply(this,arguments); }")(a),t.prototype){var p=function(){};p.prototype=t.prototype,o.prototype=new p,p.prototype=null}return o},it=ot,Ue=Function.prototype.bind||it,lt=Function.prototype.call,ft=Object.prototype.hasOwnProperty,ut=Ue,ct=ut.call(lt,ft),y,pt=zr,yt=qr,st=Hr,dt=Kr,Q=hr,K=ae,vt=Qr,br=Function,Se=function(r){try{return br('"use strict"; return ('+r+").constructor;")()}catch{}},W=Object.getOwnPropertyDescriptor;if(W)try{W({},"")}catch{W=null}var we=function(){throw new K},mt=W?function(){try{return arguments.callee,we}catch{try{return W(arguments,"callee").get}catch{return we}}}():we,z=jr(),gt=Xr(),b=Object.getPrototypeOf||(gt?function(r){return r.__proto__}:null),H={},ht=typeof Uint8Array>"u"||!b?y:b(Uint8Array),L={__proto__:null,"%AggregateError%":typeof AggregateError>"u"?y:AggregateError,"%Array%":Array,"%ArrayBuffer%":typeof ArrayBuffer>"u"?y:ArrayBuffer,"%ArrayIteratorPrototype%":z&&b?b([][Symbol.iterator]()):y,"%AsyncFromSyncIteratorPrototype%":y,"%AsyncFunction%":H,"%AsyncGenerator%":H,"%AsyncGeneratorFunction%":H,"%AsyncIteratorPrototype%":H,"%Atomics%":typeof Atomics>"u"?y:Atomics,"%BigInt%":typeof BigInt>"u"?y:BigInt,"%BigInt64Array%":typeof BigInt64Array>"u"?y:BigInt64Array,"%BigUint64Array%":typeof BigUint64Array>"u"?y:BigUint64Array,"%Boolean%":Boolean,"%DataView%":typeof DataView>"u"?y:DataView,"%Date%":Date,"%decodeURI%":decodeURI,"%decodeURIComponent%":decodeURIComponent,"%encodeURI%":encodeURI,"%encodeURIComponent%":encodeURIComponent,"%Error%":pt,"%eval%":eval,"%EvalError%":yt,"%Float32Array%":typeof Float32Array>"u"?y:Float32Array,"%Float64Array%":typeof Float64Array>"u"?y:Float64Array,"%FinalizationRegistry%":typeof FinalizationRegistry>"u"?y:FinalizationRegistry,"%Function%":br,"%GeneratorFunction%":H,"%Int8Array%":typeof Int8Array>"u"?y:Int8Array,"%Int16Array%":typeof Int16Array>"u"?y:Int16Array,"%Int32Array%":typeof Int32Array>"u"?y:Int32Array,"%isFinite%":isFinite,"%isNaN%":isNaN,"%IteratorPrototype%":z&&b?b(b([][Symbol.iterator]())):y,"%JSON%":typeof JSON=="object"?JSON:y,"%Map%":typeof Map>"u"?y:Map,"%MapIteratorPrototype%":typeof Map>"u"||!z||!b?y:b(new Map()[Symbol.iterator]()),"%Math%":Math,"%Number%":Number,"%Object%":Object,"%parseFloat%":parseFloat,"%parseInt%":parseInt,"%Promise%":typeof Promise>"u"?y:Promise,"%Proxy%":typeof Proxy>"u"?y:Proxy,"%RangeError%":st,"%ReferenceError%":dt,"%Reflect%":typeof Reflect>"u"?y:Reflect,"%RegExp%":RegExp,"%Set%":typeof Set>"u"?y:Set,"%SetIteratorPrototype%":typeof Set>"u"||!z||!b?y:b(new Set()[Symbol.iterator]()),"%SharedArrayBuffer%":typeof SharedArrayBuffer>"u"?y:SharedArrayBuffer,"%String%":String,"%StringIteratorPrototype%":z&&b?b(""[Symbol.iterator]()):y,"%Symbol%":z?Symbol:y,"%SyntaxError%":Q,"%ThrowTypeError%":mt,"%TypedArray%":ht,"%TypeError%":K,"%Uint8Array%":typeof Uint8Array>"u"?y:Uint8Array,"%Uint8ClampedArray%":typeof Uint8ClampedArray>"u"?y:Uint8ClampedArray,"%Uint16Array%":typeof Uint16Array>"u"?y:Uint16Array,"%Uint32Array%":typeof Uint32Array>"u"?y:Uint32Array,"%URIError%":vt,"%WeakMap%":typeof WeakMap>"u"?y:WeakMap,"%WeakRef%":typeof WeakRef>"u"?y:WeakRef,"%WeakSet%":typeof WeakSet>"u"?y:WeakSet};if(b)try{null.error}catch(r){var bt=b(b(r));L["%Error.prototype%"]=bt}var St=function r(e){var t;if(e==="%AsyncFunction%")t=Se("async function () {}");else if(e==="%GeneratorFunction%")t=Se("function* () {}");else if(e==="%AsyncGeneratorFunction%")t=Se("async function* () {}");else if(e==="%AsyncGenerator%"){var n=r("%AsyncGeneratorFunction%");n&&(t=n.prototype)}else if(e==="%AsyncIteratorPrototype%"){var o=r("%AsyncGenerator%");o&&b&&(t=b(o.prototype))}return L[e]=t,t},Je={__proto__:null,"%ArrayBufferPrototype%":["ArrayBuffer","prototype"],"%ArrayPrototype%":["Array","prototype"],"%ArrayProto_entries%":["Array","prototype","entries"],"%ArrayProto_forEach%":["Array","prototype","forEach"],"%ArrayProto_keys%":["Array","prototype","keys"],"%ArrayProto_values%":["Array","prototype","values"],"%AsyncFunctionPrototype%":["AsyncFunction","prototype"],"%AsyncGenerator%":["AsyncGeneratorFunction","prototype"],"%AsyncGeneratorPrototype%":["AsyncGeneratorFunction","prototype","prototype"],"%BooleanPrototype%":["Boolean","prototype"],"%DataViewPrototype%":["DataView","prototype"],"%DatePrototype%":["Date","prototype"],"%ErrorPrototype%":["Error","prototype"],"%EvalErrorPrototype%":["EvalError","prototype"],"%Float32ArrayPrototype%":["Float32Array","prototype"],"%Float64ArrayPrototype%":["Float64Array","prototype"],"%FunctionPrototype%":["Function","prototype"],"%Generator%":["GeneratorFunction","prototype"],"%GeneratorPrototype%":["GeneratorFunction","prototype","prototype"],"%Int8ArrayPrototype%":["Int8Array","prototype"],"%Int16ArrayPrototype%":["Int16Array","prototype"],"%Int32ArrayPrototype%":["Int32Array","prototype"],"%JSONParse%":["JSON","parse"],"%JSONStringify%":["JSON","stringify"],"%MapPrototype%":["Map","prototype"],"%NumberPrototype%":["Number","prototype"],"%ObjectPrototype%":["Object","prototype"],"%ObjProto_toString%":["Object","prototype","toString"],"%ObjProto_valueOf%":["Object","prototype","valueOf"],"%PromisePrototype%":["Promise","prototype"],"%PromiseProto_then%":["Promise","prototype","then"],"%Promise_all%":["Promise","all"],"%Promise_reject%":["Promise","reject"],"%Promise_resolve%":["Promise","resolve"],"%RangeErrorPrototype%":["RangeError","prototype"],"%ReferenceErrorPrototype%":["ReferenceError","prototype"],"%RegExpPrototype%":["RegExp","prototype"],"%SetPrototype%":["Set","prototype"],"%SharedArrayBufferPrototype%":["SharedArrayBuffer","prototype"],"%StringPrototype%":["String","prototype"],"%SymbolPrototype%":["Symbol","prototype"],"%SyntaxErrorPrototype%":["SyntaxError","prototype"],"%TypedArrayPrototype%":["TypedArray","prototype"],"%TypeErrorPrototype%":["TypeError","prototype"],"%Uint8ArrayPrototype%":["Uint8Array","prototype"],"%Uint8ClampedArrayPrototype%":["Uint8ClampedArray","prototype"],"%Uint16ArrayPrototype%":["Uint16Array","prototype"],"%Uint32ArrayPrototype%":["Uint32Array","prototype"],"%URIErrorPrototype%":["URIError","prototype"],"%WeakMapPrototype%":["WeakMap","prototype"],"%WeakSetPrototype%":["WeakSet","prototype"]},oe=Ue,se=ct,wt=oe.call(Function.call,Array.prototype.concat),At=oe.call(Function.apply,Array.prototype.splice),je=oe.call(Function.call,String.prototype.replace),de=oe.call(Function.call,String.prototype.slice),Et=oe.call(Function.call,RegExp.prototype.exec),Ot=/[^%.[\]]+|\[(?:(-?\d+(?:\.\d+)?)|(["'])((?:(?!\2)[^\\]|\\.)*?)\2)\]|(?=(?:\.|\[\])(?:\.|\[\]|%$))/g,Pt=/\\(\\)?/g,$t=function(e){var t=de(e,0,1),n=de(e,-1);if(t==="%"&&n!=="%")throw new Q("invalid intrinsic syntax, expected closing `%`");if(n==="%"&&t!=="%")throw new Q("invalid intrinsic syntax, expected opening `%`");var o=[];return je(e,Ot,function(a,i,f,l){o[o.length]=f?je(l,Pt,"$1"):i||a}),o},It=function(e,t){var n=e,o;if(se(Je,n)&&(o=Je[n],n="%"+o[0]+"%"),se(L,n)){var a=L[n];if(a===H&&(a=St(n)),typeof a>"u"&&!t)throw new K("intrinsic "+e+" exists, but is not available. Please file an issue!");return{alias:o,name:n,value:a}}throw new Q("intrinsic "+e+" does not exist!")},j=function(e,t){if(typeof e!="string"||e.length===0)throw new K("intrinsic name must be a non-empty string");if(arguments.length>1&&typeof t!="boolean")throw new K('"allowMissing" argument must be a boolean');if(Et(/^%?[^%]*%?$/,e)===null)throw new Q("`%` may not be present anywhere but at the beginning and end of the intrinsic name");var n=$t(e),o=n.length>0?n[0]:"",a=It("%"+o+"%",t),i=a.name,f=a.value,l=!1,p=a.alias;p&&(o=p[0],At(n,wt([0,1],p)));for(var c=1,s=!0;c<n.length;c+=1){var u=n[c],v=de(u,0,1),m=de(u,-1);if((v==='"'||v==="'"||v==="`"||m==='"'||m==="'"||m==="`")&&v!==m)throw new Q("property names with quotes must have matching quotes");if((u==="constructor"||!s)&&(l=!0),o+="."+u,i="%"+o+"%",se(L,i))f=L[i];else if(f!=null){if(!(u in f)){if(!t)throw new K("base intrinsic for "+e+" exists, but the property is not available.");return}if(W&&c+1>=n.length){var S=W(f,u);s=!!S,s&&"get"in S&&!("originalValue"in S.get)?f=S.get:f=f[u]}else s=se(f,u),f=f[u];s&&!l&&(L[i]=f)}}return f},Sr={exports:{}},Ae,Ye;function We(){if(Ye)return Ae;Ye=1;var r=j,e=r("%Object.defineProperty%",!0)||!1;if(e)try{e({},"a",{value:1})}catch{e=!1}return Ae=e,Ae}var Ft=j,pe=Ft("%Object.getOwnPropertyDescriptor%",!0);if(pe)try{pe([],"length")}catch{pe=null}var wr=pe,Xe=We(),xt=hr,q=ae,Ze=wr,Dt=function(e,t,n){if(!e||typeof e!="object"&&typeof e!="function")throw new q("`obj` must be an object or a function`");if(typeof t!="string"&&typeof t!="symbol")throw new q("`property` must be a string or a symbol`");if(arguments.length>3&&typeof arguments[3]!="boolean"&&arguments[3]!==null)throw new q("`nonEnumerable`, if provided, must be a boolean or null");if(arguments.length>4&&typeof arguments[4]!="boolean"&&arguments[4]!==null)throw new q("`nonWritable`, if provided, must be a boolean or null");if(arguments.length>5&&typeof arguments[5]!="boolean"&&arguments[5]!==null)throw new q("`nonConfigurable`, if provided, must be a boolean or null");if(arguments.length>6&&typeof arguments[6]!="boolean")throw new q("`loose`, if provided, must be a boolean");var o=arguments.length>3?arguments[3]:null,a=arguments.length>4?arguments[4]:null,i=arguments.length>5?arguments[5]:null,f=arguments.length>6?arguments[6]:!1,l=!!Ze&&Ze(e,t);if(Xe)Xe(e,t,{configurable:i===null&&l?l.configurable:!i,enumerable:o===null&&l?l.enumerable:!o,value:n,writable:a===null&&l?l.writable:!a});else if(f||!o&&!a&&!i)e[t]=n;else throw new xt("This environment does not support defining a property as non-configurable, non-writable, or non-enumerable.")},Re=We(),Ar=function(){return!!Re};Ar.hasArrayLengthDefineBug=function(){if(!Re)return null;try{return Re([],"length",{value:1}).length!==1}catch{return!0}};var Rt=Ar,_t=j,er=Dt,Tt=Rt(),rr=wr,tr=ae,Nt=_t("%Math.floor%"),Mt=function(e,t){if(typeof e!="function")throw new tr("`fn` is not a function");if(typeof t!="number"||t<0||t>4294967295||Nt(t)!==t)throw new tr("`length` must be a positive 32-bit integer");var n=arguments.length>2&&!!arguments[2],o=!0,a=!0;if("length"in e&&rr){var i=rr(e,"length");i&&!i.configurable&&(o=!1),i&&!i.writable&&(a=!1)}return(o||a||!n)&&(Tt?er(e,"length",t,!0,!0):er(e,"length",t)),e};(function(r){var e=Ue,t=j,n=Mt,o=ae,a=t("%Function.prototype.apply%"),i=t("%Function.prototype.call%"),f=t("%Reflect.apply%",!0)||e.call(i,a),l=We(),p=t("%Math.max%");r.exports=function(u){if(typeof u!="function")throw new o("a function is required");var v=f(e,i,arguments);return n(v,1+p(0,u.length-(arguments.length-1)),!0)};var c=function(){return f(e,a,arguments)};l?l(r.exports,"apply",{value:c}):r.exports.apply=c})(Sr);var Bt=Sr.exports,Er=j,Or=Bt,Ct=Or(Er("String.prototype.indexOf")),Ut=function(e,t){var n=Er(e,!!t);return typeof n=="function"&&Ct(e,".prototype.")>-1?Or(n):n};const Wt={},Lt=Object.freeze(Object.defineProperty({__proto__:null,default:Wt},Symbol.toStringTag,{value:"Module"})),Gt=kr(Lt);var Le=typeof Map=="function"&&Map.prototype,Ee=Object.getOwnPropertyDescriptor&&Le?Object.getOwnPropertyDescriptor(Map.prototype,"size"):null,ve=Le&&Ee&&typeof Ee.get=="function"?Ee.get:null,nr=Le&&Map.prototype.forEach,Ge=typeof Set=="function"&&Set.prototype,Oe=Object.getOwnPropertyDescriptor&&Ge?Object.getOwnPropertyDescriptor(Set.prototype,"size"):null,me=Ge&&Oe&&typeof Oe.get=="function"?Oe.get:null,ar=Ge&&Set.prototype.forEach,kt=typeof WeakMap=="function"&&WeakMap.prototype,re=kt?WeakMap.prototype.has:null,zt=typeof WeakSet=="function"&&WeakSet.prototype,te=zt?WeakSet.prototype.has:null,qt=typeof WeakRef=="function"&&WeakRef.prototype,or=qt?WeakRef.prototype.deref:null,Ht=Boolean.prototype.valueOf,Kt=Object.prototype.toString,Qt=Function.prototype.toString,Vt=String.prototype.match,ke=String.prototype.slice,N=String.prototype.replace,Jt=String.prototype.toUpperCase,ir=String.prototype.toLowerCase,Pr=RegExp.prototype.test,lr=Array.prototype.concat,$=Array.prototype.join,jt=Array.prototype.slice,fr=Math.floor,_e=typeof BigInt=="function"?BigInt.prototype.valueOf:null,Pe=Object.getOwnPropertySymbols,Te=typeof Symbol=="function"&&typeof Symbol.iterator=="symbol"?Symbol.prototype.toString:null,V=typeof Symbol=="function"&&typeof Symbol.iterator=="object",w=typeof Symbol=="function"&&Symbol.toStringTag&&(typeof Symbol.toStringTag===V||!0)?Symbol.toStringTag:null,$r=Object.prototype.propertyIsEnumerable,ur=(typeof Reflect=="function"?Reflect.getPrototypeOf:Object.getPrototypeOf)||([].__proto__===Array.prototype?function(r){return r.__proto__}:null);function cr(r,e){if(r===1/0||r===-1/0||r!==r||r&&r>-1e3&&r<1e3||Pr.call(/e/,e))return e;var t=/[0-9](?=(?:[0-9]{3})+(?![0-9]))/g;if(typeof r=="number"){var n=r<0?-fr(-r):fr(r);if(n!==r){var o=String(n),a=ke.call(e,o.length+1);return N.call(o,t,"$&_")+"."+N.call(N.call(a,/([0-9]{3})/g,"$&_"),/_$/,"")}}return N.call(e,t,"$&_")}var Ne=Gt,pr=Ne.custom,yr=Fr(pr)?pr:null,Yt=function r(e,t,n,o){var a=t||{};if(T(a,"quoteStyle")&&a.quoteStyle!=="single"&&a.quoteStyle!=="double")throw new TypeError('option "quoteStyle" must be "single" or "double"');if(T(a,"maxStringLength")&&(typeof a.maxStringLength=="number"?a.maxStringLength<0&&a.maxStringLength!==1/0:a.maxStringLength!==null))throw new TypeError('option "maxStringLength", if provided, must be a positive integer, Infinity, or `null`');var i=T(a,"customInspect")?a.customInspect:!0;if(typeof i!="boolean"&&i!=="symbol")throw new TypeError("option \"customInspect\", if provided, must be `true`, `false`, or `'symbol'`");if(T(a,"indent")&&a.indent!==null&&a.indent!=="	"&&!(parseInt(a.indent,10)===a.indent&&a.indent>0))throw new TypeError('option "indent" must be "\\t", an integer > 0, or `null`');if(T(a,"numericSeparator")&&typeof a.numericSeparator!="boolean")throw new TypeError('option "numericSeparator", if provided, must be `true` or `false`');var f=a.numericSeparator;if(typeof e>"u")return"undefined";if(e===null)return"null";if(typeof e=="boolean")return e?"true":"false";if(typeof e=="string")return Dr(e,a);if(typeof e=="number"){if(e===0)return 1/0/e>0?"0":"-0";var l=String(e);return f?cr(e,l):l}if(typeof e=="bigint"){var p=String(e)+"n";return f?cr(e,p):p}var c=typeof a.depth>"u"?5:a.depth;if(typeof n>"u"&&(n=0),n>=c&&c>0&&typeof e=="object")return Me(e)?"[Array]":"[Object]";var s=mn(a,n);if(typeof o>"u")o=[];else if(xr(o,e)>=0)return"[Circular]";function u(E,R,_){if(R&&(o=jt.call(o),o.push(R)),_){var Z={depth:a.depth};return T(a,"quoteStyle")&&(Z.quoteStyle=a.quoteStyle),r(E,Z,n+1,o)}return r(E,a,n+1,o)}if(typeof e=="function"&&!sr(e)){var v=ln(e),m=fe(e,u);return"[Function"+(v?": "+v:" (anonymous)")+"]"+(m.length>0?" { "+$.call(m,", ")+" }":"")}if(Fr(e)){var S=V?N.call(String(e),/^(Symbol\(.*\))_[^)]*$/,"$1"):Te.call(e);return typeof e=="object"&&!V?ee(S):S}if(sn(e)){for(var A="<"+ir.call(String(e.nodeName)),I=e.attributes||[],F=0;F<I.length;F++)A+=" "+I[F].name+"="+Ir(Xt(I[F].value),"double",a);return A+=">",e.childNodes&&e.childNodes.length&&(A+="..."),A+="</"+ir.call(String(e.nodeName))+">",A}if(Me(e)){if(e.length===0)return"[]";var d=fe(e,u);return s&&!vn(d)?"["+Be(d,s)+"]":"[ "+$.call(d,", ")+" ]"}if(en(e)){var x=fe(e,u);return!("cause"in Error.prototype)&&"cause"in e&&!$r.call(e,"cause")?"{ ["+String(e)+"] "+$.call(lr.call("[cause]: "+u(e.cause),x),", ")+" }":x.length===0?"["+String(e)+"]":"{ ["+String(e)+"] "+$.call(x,", ")+" }"}if(typeof e=="object"&&i){if(yr&&typeof e[yr]=="function"&&Ne)return Ne(e,{depth:c-n});if(i!=="symbol"&&typeof e.inspect=="function")return e.inspect()}if(fn(e)){var B=[];return nr&&nr.call(e,function(E,R){B.push(u(R,e,!0)+" => "+u(E,e))}),dr("Map",ve.call(e),B,s)}if(pn(e)){var X=[];return ar&&ar.call(e,function(E){X.push(u(E,e))}),dr("Set",me.call(e),X,s)}if(un(e))return $e("WeakMap");if(yn(e))return $e("WeakSet");if(cn(e))return $e("WeakRef");if(tn(e))return ee(u(Number(e)));if(an(e))return ee(u(_e.call(e)));if(nn(e))return ee(Ht.call(e));if(rn(e))return ee(u(String(e)));if(typeof window<"u"&&e===window)return"{ [object Window] }";if(typeof globalThis<"u"&&e===globalThis||typeof Ke<"u"&&e===Ke)return"{ [object globalThis] }";if(!Zt(e)&&!sr(e)){var G=fe(e,u),ie=ur?ur(e)===Object.prototype:e instanceof Object||e.constructor===Object,C=e instanceof Object?"":"null prototype",D=!ie&&w&&Object(e)===e&&w in e?ke.call(M(e),8,-1):C?"Object":"",le=ie||typeof e.constructor!="function"?"":e.constructor.name?e.constructor.name+" ":"",k=le+(D||C?"["+$.call(lr.call([],D||[],C||[]),": ")+"] ":"");return G.length===0?k+"{}":s?k+"{"+Be(G,s)+"}":k+"{ "+$.call(G,", ")+" }"}return String(e)};function Ir(r,e,t){var n=(t.quoteStyle||e)==="double"?'"':"'";return n+r+n}function Xt(r){return N.call(String(r),/"/g,"&quot;")}function Me(r){return M(r)==="[object Array]"&&(!w||!(typeof r=="object"&&w in r))}function Zt(r){return M(r)==="[object Date]"&&(!w||!(typeof r=="object"&&w in r))}function sr(r){return M(r)==="[object RegExp]"&&(!w||!(typeof r=="object"&&w in r))}function en(r){return M(r)==="[object Error]"&&(!w||!(typeof r=="object"&&w in r))}function rn(r){return M(r)==="[object String]"&&(!w||!(typeof r=="object"&&w in r))}function tn(r){return M(r)==="[object Number]"&&(!w||!(typeof r=="object"&&w in r))}function nn(r){return M(r)==="[object Boolean]"&&(!w||!(typeof r=="object"&&w in r))}function Fr(r){if(V)return r&&typeof r=="object"&&r instanceof Symbol;if(typeof r=="symbol")return!0;if(!r||typeof r!="object"||!Te)return!1;try{return Te.call(r),!0}catch{}return!1}function an(r){if(!r||typeof r!="object"||!_e)return!1;try{return _e.call(r),!0}catch{}return!1}var on=Object.prototype.hasOwnProperty||function(r){return r in this};function T(r,e){return on.call(r,e)}function M(r){return Kt.call(r)}function ln(r){if(r.name)return r.name;var e=Vt.call(Qt.call(r),/^function\s*([\w$]+)/);return e?e[1]:null}function xr(r,e){if(r.indexOf)return r.indexOf(e);for(var t=0,n=r.length;t<n;t++)if(r[t]===e)return t;return-1}function fn(r){if(!ve||!r||typeof r!="object")return!1;try{ve.call(r);try{me.call(r)}catch{return!0}return r instanceof Map}catch{}return!1}function un(r){if(!re||!r||typeof r!="object")return!1;try{re.call(r,re);try{te.call(r,te)}catch{return!0}return r instanceof WeakMap}catch{}return!1}function cn(r){if(!or||!r||typeof r!="object")return!1;try{return or.call(r),!0}catch{}return!1}function pn(r){if(!me||!r||typeof r!="object")return!1;try{me.call(r);try{ve.call(r)}catch{return!0}return r instanceof Set}catch{}return!1}function yn(r){if(!te||!r||typeof r!="object")return!1;try{te.call(r,te);try{re.call(r,re)}catch{return!0}return r instanceof WeakSet}catch{}return!1}function sn(r){return!r||typeof r!="object"?!1:typeof HTMLElement<"u"&&r instanceof HTMLElement?!0:typeof r.nodeName=="string"&&typeof r.getAttribute=="function"}function Dr(r,e){if(r.length>e.maxStringLength){var t=r.length-e.maxStringLength,n="... "+t+" more character"+(t>1?"s":"");return Dr(ke.call(r,0,e.maxStringLength),e)+n}var o=N.call(N.call(r,/(['\\])/g,"\\$1"),/[\x00-\x1f]/g,dn);return Ir(o,"single",e)}function dn(r){var e=r.charCodeAt(0),t={8:"b",9:"t",10:"n",12:"f",13:"r"}[e];return t?"\\"+t:"\\x"+(e<16?"0":"")+Jt.call(e.toString(16))}function ee(r){return"Object("+r+")"}function $e(r){return r+" { ? }"}function dr(r,e,t,n){var o=n?Be(t,n):$.call(t,", ");return r+" ("+e+") {"+o+"}"}function vn(r){for(var e=0;e<r.length;e++)if(xr(r[e],`
`)>=0)return!1;return!0}function mn(r,e){var t;if(r.indent==="	")t="	";else if(typeof r.indent=="number"&&r.indent>0)t=$.call(Array(r.indent+1)," ");else return null;return{base:t,prev:$.call(Array(e+1),t)}}function Be(r,e){if(r.length===0)return"";var t=`
`+e.prev+e.base;return t+$.call(r,","+t)+`
`+e.prev}function fe(r,e){var t=Me(r),n=[];if(t){n.length=r.length;for(var o=0;o<r.length;o++)n[o]=T(r,o)?e(r[o],r):""}var a=typeof Pe=="function"?Pe(r):[],i;if(V){i={};for(var f=0;f<a.length;f++)i["$"+a[f]]=a[f]}for(var l in r)T(r,l)&&(t&&String(Number(l))===l&&l<r.length||V&&i["$"+l]instanceof Symbol||(Pr.call(/[^\w$]/,l)?n.push(e(l,r)+": "+e(r[l],r)):n.push(l+": "+e(r[l],r))));if(typeof Pe=="function")for(var p=0;p<a.length;p++)$r.call(r,a[p])&&n.push("["+e(a[p])+"]: "+e(r[a[p]],r));return n}var Rr=j,Y=Ut,gn=Yt,hn=ae,ue=Rr("%WeakMap%",!0),ce=Rr("%Map%",!0),bn=Y("WeakMap.prototype.get",!0),Sn=Y("WeakMap.prototype.set",!0),wn=Y("WeakMap.prototype.has",!0),An=Y("Map.prototype.get",!0),En=Y("Map.prototype.set",!0),On=Y("Map.prototype.has",!0),ze=function(r,e){for(var t=r,n;(n=t.next)!==null;t=n)if(n.key===e)return t.next=n.next,n.next=r.next,r.next=n,n},Pn=function(r,e){var t=ze(r,e);return t&&t.value},$n=function(r,e,t){var n=ze(r,e);n?n.value=t:r.next={key:e,next:r.next,value:t}},In=function(r,e){return!!ze(r,e)},Fn=function(){var e,t,n,o={assert:function(a){if(!o.has(a))throw new hn("Side channel does not contain "+gn(a))},get:function(a){if(ue&&a&&(typeof a=="object"||typeof a=="function")){if(e)return bn(e,a)}else if(ce){if(t)return An(t,a)}else if(n)return Pn(n,a)},has:function(a){if(ue&&a&&(typeof a=="object"||typeof a=="function")){if(e)return wn(e,a)}else if(ce){if(t)return On(t,a)}else if(n)return In(n,a);return!1},set:function(a,i){ue&&a&&(typeof a=="object"||typeof a=="function")?(e||(e=new ue),Sn(e,a,i)):ce?(t||(t=new ce),En(t,a,i)):(n||(n={key:{},next:null}),$n(n,a,i))}};return o},xn=String.prototype.replace,Dn=/%20/g,Ie={RFC1738:"RFC1738",RFC3986:"RFC3986"},qe={default:Ie.RFC3986,formatters:{RFC1738:function(r){return xn.call(r,Dn,"+")},RFC3986:function(r){return String(r)}},RFC1738:Ie.RFC1738,RFC3986:Ie.RFC3986},Rn=qe,Fe=Object.prototype.hasOwnProperty,U=Array.isArray,O=function(){for(var r=[],e=0;e<256;++e)r.push("%"+((e<16?"0":"")+e.toString(16)).toUpperCase());return r}(),_n=function(e){for(;e.length>1;){var t=e.pop(),n=t.obj[t.prop];if(U(n)){for(var o=[],a=0;a<n.length;++a)typeof n[a]<"u"&&o.push(n[a]);t.obj[t.prop]=o}}},_r=function(e,t){for(var n=t&&t.plainObjects?Object.create(null):{},o=0;o<e.length;++o)typeof e[o]<"u"&&(n[o]=e[o]);return n},Tn=function r(e,t,n){if(!t)return e;if(typeof t!="object"){if(U(e))e.push(t);else if(e&&typeof e=="object")(n&&(n.plainObjects||n.allowPrototypes)||!Fe.call(Object.prototype,t))&&(e[t]=!0);else return[e,t];return e}if(!e||typeof e!="object")return[e].concat(t);var o=e;return U(e)&&!U(t)&&(o=_r(e,n)),U(e)&&U(t)?(t.forEach(function(a,i){if(Fe.call(e,i)){var f=e[i];f&&typeof f=="object"&&a&&typeof a=="object"?e[i]=r(f,a,n):e.push(a)}else e[i]=a}),e):Object.keys(t).reduce(function(a,i){var f=t[i];return Fe.call(a,i)?a[i]=r(a[i],f,n):a[i]=f,a},o)},Nn=function(e,t){return Object.keys(t).reduce(function(n,o){return n[o]=t[o],n},e)},Mn=function(r,e,t){var n=r.replace(/\+/g," ");if(t==="iso-8859-1")return n.replace(/%[0-9a-f]{2}/gi,unescape);try{return decodeURIComponent(n)}catch{return n}},xe=1024,Bn=function(e,t,n,o,a){if(e.length===0)return e;var i=e;if(typeof e=="symbol"?i=Symbol.prototype.toString.call(e):typeof e!="string"&&(i=String(e)),n==="iso-8859-1")return escape(i).replace(/%u[0-9a-f]{4}/gi,function(v){return"%26%23"+parseInt(v.slice(2),16)+"%3B"});for(var f="",l=0;l<i.length;l+=xe){for(var p=i.length>=xe?i.slice(l,l+xe):i,c=[],s=0;s<p.length;++s){var u=p.charCodeAt(s);if(u===45||u===46||u===95||u===126||u>=48&&u<=57||u>=65&&u<=90||u>=97&&u<=122||a===Rn.RFC1738&&(u===40||u===41)){c[c.length]=p.charAt(s);continue}if(u<128){c[c.length]=O[u];continue}if(u<2048){c[c.length]=O[192|u>>6]+O[128|u&63];continue}if(u<55296||u>=57344){c[c.length]=O[224|u>>12]+O[128|u>>6&63]+O[128|u&63];continue}s+=1,u=65536+((u&1023)<<10|p.charCodeAt(s)&1023),c[c.length]=O[240|u>>18]+O[128|u>>12&63]+O[128|u>>6&63]+O[128|u&63]}f+=c.join("")}return f},Cn=function(e){for(var t=[{obj:{o:e},prop:"o"}],n=[],o=0;o<t.length;++o)for(var a=t[o],i=a.obj[a.prop],f=Object.keys(i),l=0;l<f.length;++l){var p=f[l],c=i[p];typeof c=="object"&&c!==null&&n.indexOf(c)===-1&&(t.push({obj:i,prop:p}),n.push(c))}return _n(t),e},Un=function(e){return Object.prototype.toString.call(e)==="[object RegExp]"},Wn=function(e){return!e||typeof e!="object"?!1:!!(e.constructor&&e.constructor.isBuffer&&e.constructor.isBuffer(e))},Ln=function(e,t){return[].concat(e,t)},Gn=function(e,t){if(U(e)){for(var n=[],o=0;o<e.length;o+=1)n.push(t(e[o]));return n}return t(e)},Tr={arrayToObject:_r,assign:Nn,combine:Ln,compact:Cn,decode:Mn,encode:Bn,isBuffer:Wn,isRegExp:Un,maybeMap:Gn,merge:Tn},Nr=Fn,ye=Tr,ne=qe,kn=Object.prototype.hasOwnProperty,Mr={brackets:function(e){return e+"[]"},comma:"comma",indices:function(e,t){return e+"["+t+"]"},repeat:function(e){return e}},P=Array.isArray,zn=Array.prototype.push,Br=function(r,e){zn.apply(r,P(e)?e:[e])},qn=Date.prototype.toISOString,vr=ne.default,h={addQueryPrefix:!1,allowDots:!1,allowEmptyArrays:!1,arrayFormat:"indices",charset:"utf-8",charsetSentinel:!1,delimiter:"&",encode:!0,encodeDotInKeys:!1,encoder:ye.encode,encodeValuesOnly:!1,format:vr,formatter:ne.formatters[vr],indices:!1,serializeDate:function(e){return qn.call(e)},skipNulls:!1,strictNullHandling:!1},Hn=function(e){return typeof e=="string"||typeof e=="number"||typeof e=="boolean"||typeof e=="symbol"||typeof e=="bigint"},De={},Kn=function r(e,t,n,o,a,i,f,l,p,c,s,u,v,m,S,A,I,F){for(var d=e,x=F,B=0,X=!1;(x=x.get(De))!==void 0&&!X;){var G=x.get(e);if(B+=1,typeof G<"u"){if(G===B)throw new RangeError("Cyclic object value");X=!0}typeof x.get(De)>"u"&&(B=0)}if(typeof c=="function"?d=c(t,d):d instanceof Date?d=v(d):n==="comma"&&P(d)&&(d=ye.maybeMap(d,function(he){return he instanceof Date?v(he):he})),d===null){if(i)return p&&!A?p(t,h.encoder,I,"key",m):t;d=""}if(Hn(d)||ye.isBuffer(d)){if(p){var ie=A?t:p(t,h.encoder,I,"key",m);return[S(ie)+"="+S(p(d,h.encoder,I,"value",m))]}return[S(t)+"="+S(String(d))]}var C=[];if(typeof d>"u")return C;var D;if(n==="comma"&&P(d))A&&p&&(d=ye.maybeMap(d,p)),D=[{value:d.length>0?d.join(",")||null:void 0}];else if(P(c))D=c;else{var le=Object.keys(d);D=s?le.sort(s):le}var k=l?t.replace(/\./g,"%2E"):t,E=o&&P(d)&&d.length===1?k+"[]":k;if(a&&P(d)&&d.length===0)return E+"[]";for(var R=0;R<D.length;++R){var _=D[R],Z=typeof _=="object"&&typeof _.value<"u"?_.value:d[_];if(!(f&&Z===null)){var ge=u&&l?_.replace(/\./g,"%2E"):_,Wr=P(d)?typeof n=="function"?n(E,ge):E:E+(u?"."+ge:"["+ge+"]");F.set(e,B);var He=Nr();He.set(De,F),Br(C,r(Z,Wr,n,o,a,i,f,l,n==="comma"&&A&&P(d)?null:p,c,s,u,v,m,S,A,I,He))}}return C},Qn=function(e){if(!e)return h;if(typeof e.allowEmptyArrays<"u"&&typeof e.allowEmptyArrays!="boolean")throw new TypeError("`allowEmptyArrays` option can only be `true` or `false`, when provided");if(typeof e.encodeDotInKeys<"u"&&typeof e.encodeDotInKeys!="boolean")throw new TypeError("`encodeDotInKeys` option can only be `true` or `false`, when provided");if(e.encoder!==null&&typeof e.encoder<"u"&&typeof e.encoder!="function")throw new TypeError("Encoder has to be a function.");var t=e.charset||h.charset;if(typeof e.charset<"u"&&e.charset!=="utf-8"&&e.charset!=="iso-8859-1")throw new TypeError("The charset option must be either utf-8, iso-8859-1, or undefined");var n=ne.default;if(typeof e.format<"u"){if(!kn.call(ne.formatters,e.format))throw new TypeError("Unknown format option provided.");n=e.format}var o=ne.formatters[n],a=h.filter;(typeof e.filter=="function"||P(e.filter))&&(a=e.filter);var i;if(e.arrayFormat in Mr?i=e.arrayFormat:"indices"in e?i=e.indices?"indices":"repeat":i=h.arrayFormat,"commaRoundTrip"in e&&typeof e.commaRoundTrip!="boolean")throw new TypeError("`commaRoundTrip` must be a boolean, or absent");var f=typeof e.allowDots>"u"?e.encodeDotInKeys===!0?!0:h.allowDots:!!e.allowDots;return{addQueryPrefix:typeof e.addQueryPrefix=="boolean"?e.addQueryPrefix:h.addQueryPrefix,allowDots:f,allowEmptyArrays:typeof e.allowEmptyArrays=="boolean"?!!e.allowEmptyArrays:h.allowEmptyArrays,arrayFormat:i,charset:t,charsetSentinel:typeof e.charsetSentinel=="boolean"?e.charsetSentinel:h.charsetSentinel,commaRoundTrip:e.commaRoundTrip,delimiter:typeof e.delimiter>"u"?h.delimiter:e.delimiter,encode:typeof e.encode=="boolean"?e.encode:h.encode,encodeDotInKeys:typeof e.encodeDotInKeys=="boolean"?e.encodeDotInKeys:h.encodeDotInKeys,encoder:typeof e.encoder=="function"?e.encoder:h.encoder,encodeValuesOnly:typeof e.encodeValuesOnly=="boolean"?e.encodeValuesOnly:h.encodeValuesOnly,filter:a,format:n,formatter:o,serializeDate:typeof e.serializeDate=="function"?e.serializeDate:h.serializeDate,skipNulls:typeof e.skipNulls=="boolean"?e.skipNulls:h.skipNulls,sort:typeof e.sort=="function"?e.sort:null,strictNullHandling:typeof e.strictNullHandling=="boolean"?e.strictNullHandling:h.strictNullHandling}},Vn=function(r,e){var t=r,n=Qn(e),o,a;typeof n.filter=="function"?(a=n.filter,t=a("",t)):P(n.filter)&&(a=n.filter,o=a);var i=[];if(typeof t!="object"||t===null)return"";var f=Mr[n.arrayFormat],l=f==="comma"&&n.commaRoundTrip;o||(o=Object.keys(t)),n.sort&&o.sort(n.sort);for(var p=Nr(),c=0;c<o.length;++c){var s=o[c];n.skipNulls&&t[s]===null||Br(i,Kn(t[s],s,f,l,n.allowEmptyArrays,n.strictNullHandling,n.skipNulls,n.encodeDotInKeys,n.encode?n.encoder:null,n.filter,n.sort,n.allowDots,n.serializeDate,n.format,n.formatter,n.encodeValuesOnly,n.charset,p))}var u=i.join(n.delimiter),v=n.addQueryPrefix===!0?"?":"";return n.charsetSentinel&&(n.charset==="iso-8859-1"?v+="utf8=%26%2310003%3B&":v+="utf8=%E2%9C%93&"),u.length>0?v+u:""},J=Tr,Ce=Object.prototype.hasOwnProperty,Jn=Array.isArray,g={allowDots:!1,allowEmptyArrays:!1,allowPrototypes:!1,allowSparse:!1,arrayLimit:20,charset:"utf-8",charsetSentinel:!1,comma:!1,decodeDotInKeys:!1,decoder:J.decode,delimiter:"&",depth:5,duplicates:"combine",ignoreQueryPrefix:!1,interpretNumericEntities:!1,parameterLimit:1e3,parseArrays:!0,plainObjects:!1,strictDepth:!1,strictNullHandling:!1},jn=function(r){return r.replace(/&#(\d+);/g,function(e,t){return String.fromCharCode(parseInt(t,10))})},Cr=function(r,e){return r&&typeof r=="string"&&e.comma&&r.indexOf(",")>-1?r.split(","):r},Yn="utf8=%26%2310003%3B",Xn="utf8=%E2%9C%93",Zn=function(e,t){var n={__proto__:null},o=t.ignoreQueryPrefix?e.replace(/^\?/,""):e;o=o.replace(/%5B/gi,"[").replace(/%5D/gi,"]");var a=t.parameterLimit===1/0?void 0:t.parameterLimit,i=o.split(t.delimiter,a),f=-1,l,p=t.charset;if(t.charsetSentinel)for(l=0;l<i.length;++l)i[l].indexOf("utf8=")===0&&(i[l]===Xn?p="utf-8":i[l]===Yn&&(p="iso-8859-1"),f=l,l=i.length);for(l=0;l<i.length;++l)if(l!==f){var c=i[l],s=c.indexOf("]="),u=s===-1?c.indexOf("="):s+1,v,m;u===-1?(v=t.decoder(c,g.decoder,p,"key"),m=t.strictNullHandling?null:""):(v=t.decoder(c.slice(0,u),g.decoder,p,"key"),m=J.maybeMap(Cr(c.slice(u+1),t),function(A){return t.decoder(A,g.decoder,p,"value")})),m&&t.interpretNumericEntities&&p==="iso-8859-1"&&(m=jn(m)),c.indexOf("[]=")>-1&&(m=Jn(m)?[m]:m);var S=Ce.call(n,v);S&&t.duplicates==="combine"?n[v]=J.combine(n[v],m):(!S||t.duplicates==="last")&&(n[v]=m)}return n},ea=function(r,e,t,n){for(var o=n?e:Cr(e,t),a=r.length-1;a>=0;--a){var i,f=r[a];if(f==="[]"&&t.parseArrays)i=t.allowEmptyArrays&&(o===""||t.strictNullHandling&&o===null)?[]:[].concat(o);else{i=t.plainObjects?Object.create(null):{};var l=f.charAt(0)==="["&&f.charAt(f.length-1)==="]"?f.slice(1,-1):f,p=t.decodeDotInKeys?l.replace(/%2E/g,"."):l,c=parseInt(p,10);!t.parseArrays&&p===""?i={0:o}:!isNaN(c)&&f!==p&&String(c)===p&&c>=0&&t.parseArrays&&c<=t.arrayLimit?(i=[],i[c]=o):p!=="__proto__"&&(i[p]=o)}o=i}return o},ra=function(e,t,n,o){if(e){var a=n.allowDots?e.replace(/\.([^.[]+)/g,"[$1]"):e,i=/(\[[^[\]]*])/,f=/(\[[^[\]]*])/g,l=n.depth>0&&i.exec(a),p=l?a.slice(0,l.index):a,c=[];if(p){if(!n.plainObjects&&Ce.call(Object.prototype,p)&&!n.allowPrototypes)return;c.push(p)}for(var s=0;n.depth>0&&(l=f.exec(a))!==null&&s<n.depth;){if(s+=1,!n.plainObjects&&Ce.call(Object.prototype,l[1].slice(1,-1))&&!n.allowPrototypes)return;c.push(l[1])}if(l){if(n.strictDepth===!0)throw new RangeError("Input depth exceeded depth option of "+n.depth+" and strictDepth is true");c.push("["+a.slice(l.index)+"]")}return ea(c,t,n,o)}},ta=function(e){if(!e)return g;if(typeof e.allowEmptyArrays<"u"&&typeof e.allowEmptyArrays!="boolean")throw new TypeError("`allowEmptyArrays` option can only be `true` or `false`, when provided");if(typeof e.decodeDotInKeys<"u"&&typeof e.decodeDotInKeys!="boolean")throw new TypeError("`decodeDotInKeys` option can only be `true` or `false`, when provided");if(e.decoder!==null&&typeof e.decoder<"u"&&typeof e.decoder!="function")throw new TypeError("Decoder has to be a function.");if(typeof e.charset<"u"&&e.charset!=="utf-8"&&e.charset!=="iso-8859-1")throw new TypeError("The charset option must be either utf-8, iso-8859-1, or undefined");var t=typeof e.charset>"u"?g.charset:e.charset,n=typeof e.duplicates>"u"?g.duplicates:e.duplicates;if(n!=="combine"&&n!=="first"&&n!=="last")throw new TypeError("The duplicates option must be either combine, first, or last");var o=typeof e.allowDots>"u"?e.decodeDotInKeys===!0?!0:g.allowDots:!!e.allowDots;return{allowDots:o,allowEmptyArrays:typeof e.allowEmptyArrays=="boolean"?!!e.allowEmptyArrays:g.allowEmptyArrays,allowPrototypes:typeof e.allowPrototypes=="boolean"?e.allowPrototypes:g.allowPrototypes,allowSparse:typeof e.allowSparse=="boolean"?e.allowSparse:g.allowSparse,arrayLimit:typeof e.arrayLimit=="number"?e.arrayLimit:g.arrayLimit,charset:t,charsetSentinel:typeof e.charsetSentinel=="boolean"?e.charsetSentinel:g.charsetSentinel,comma:typeof e.comma=="boolean"?e.comma:g.comma,decodeDotInKeys:typeof e.decodeDotInKeys=="boolean"?e.decodeDotInKeys:g.decodeDotInKeys,decoder:typeof e.decoder=="function"?e.decoder:g.decoder,delimiter:typeof e.delimiter=="string"||J.isRegExp(e.delimiter)?e.delimiter:g.delimiter,depth:typeof e.depth=="number"||e.depth===!1?+e.depth:g.depth,duplicates:n,ignoreQueryPrefix:e.ignoreQueryPrefix===!0,interpretNumericEntities:typeof e.interpretNumericEntities=="boolean"?e.interpretNumericEntities:g.interpretNumericEntities,parameterLimit:typeof e.parameterLimit=="number"?e.parameterLimit:g.parameterLimit,parseArrays:e.parseArrays!==!1,plainObjects:typeof e.plainObjects=="boolean"?e.plainObjects:g.plainObjects,strictDepth:typeof e.strictDepth=="boolean"?!!e.strictDepth:g.strictDepth,strictNullHandling:typeof e.strictNullHandling=="boolean"?e.strictNullHandling:g.strictNullHandling}},na=function(r,e){var t=ta(e);if(r===""||r===null||typeof r>"u")return t.plainObjects?Object.create(null):{};for(var n=typeof r=="string"?Zn(r,t):r,o=t.plainObjects?Object.create(null):{},a=Object.keys(n),i=0;i<a.length;++i){var f=a[i],l=ra(f,n[f],t,typeof r=="string");o=J.merge(o,l,t)}return t.allowSparse===!0?o:J.compact(o)},aa=Vn,oa=na,ia=qe,la={formats:ia,parse:oa,stringify:aa};const fa=Gr(la);mr.defaults.paramsSerializer=r=>fa.stringify(r);const Ur=mr.create({timeout:1e3});Ur.interceptors.request.use(r=>{const{getToken:e}=gr(),t=e();return t&&(r.headers.Authorization=`Bearer ${t}`,console.log(r.headers.Authorization)),r},r=>(console.log(r),Promise.reject(r)));Ur.interceptors.response.use(r=>r.status===200?r:r.status===404?Promise.reject("404: 페이지 없음 "+r.request):r,async r=>{var e,t;if(((e=r.response)==null?void 0:e.status)===401){const{logout:n}=gr();return n(),Lr.push("/auth/login?error=loing_required"),Promise.reject({error:"로그인이 필요한 서비스입니다."})}else if(((t=r.response)==null?void 0:t.status)===403)return Promise.reject({error:"권한이 부족합니다."});return Promise.reject(r)});export{Ur as i};
