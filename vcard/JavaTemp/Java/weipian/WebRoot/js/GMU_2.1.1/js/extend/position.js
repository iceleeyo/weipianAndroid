(function(e,a){var g=e.fn.position,k=Math.round,c=/^(left|center|right)([\+\-]\d+%?)?$/,h=/^(top|center|bottom)([\+\-]\d+%?)?$/,b=/%$/;function i(n,m){return(parseInt(n,10)||0)*(b.test(n)?m/100:1)}function l(p,o,n,m){return[p[0]==="right"?n:p[0]==="center"?n/2:0,p[1]==="bottom"?m:p[1]==="center"?m/2:0,i(o[0],n),i(o[1],m)]}function f(n){var m=n[0],o=m.preventDefault;m=m.touches&&m.touches[0]||m;if(m.nodeType===9||m===window||o){return{width:o?0:n.width(),height:o?0:n.height(),top:m.pageYOffset||m.pageY||0,left:m.pageXOffset||m.pageX||0}}return n.offset()}function j(n){var m=e(n=(n||window)),o=f(m);n=m[0];return{$el:m,width:o.width,height:o.height,scrollLeft:n.pageXOffset||n.scrollLeft,scrollTop:n.pageYOffset||n.scrollTop}}function d(n,m){["my","at"].forEach(function(p){var r=(n[p]||"").split(" "),o=n[p]=["center","center"],q=m[p]=[0,0];r.length===1&&r[h.test(r[0])?"unshift":"push"]("center");c.test(r[0])&&(o[0]=RegExp.$1)&&(q[0]=RegExp.$2);h.test(r[1])&&(o[1]=RegExp.$1)&&(q[1]=RegExp.$2)})}e.fn.position=function(o){if(!o||!o.of){return g.call(this)}o=e.extend({},o);var r=e(o.of),t=o.collision,m=t&&j(o.within),q={},p=f(r),s={left:p.left,top:p.top},n;r[0].preventDefault&&(o.at="left top");d(o,q);n=l(o.at,q.at,p.width,p.height);s.left+=n[0]+n[2];s.top+=n[1]+n[3];return this.each(function(){var u=e(this),v=u.offset(),x=e.extend({},s),w=l(o.my,q.my,v.width,v.height);x.left=k(x.left+w[2]-w[0]);x.top=k(x.top+w[3]-w[1]);t&&t.call(this,x,{of:p,offset:v,my:o.my,at:o.at,within:m,$el:u});x.using=o.using;u.offset(x)})}})(Zepto);