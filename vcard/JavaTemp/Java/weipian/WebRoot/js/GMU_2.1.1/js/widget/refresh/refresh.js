(function(b, a, c) {
	b.define("Refresh", {
		options : {
			load : null,
			statechange : null
		},
		_init : function() {
			var e = this, d = e._options;
			e.on("ready", function() {
				a.each(["up", "down"], function(h, g) {
							var f = d["$" + g + "Elem"], j = f.get(0);
							if (f.length) {
								e._status(g, true);
								if (!j.childNodes.length
										|| (f.find(".ui-refresh-icon").length && f
												.find(".ui-refresh-label").length)) {
									!j.childNodes.length && e._createBtn(g);
									d.refreshInfo || (d.refreshInfo = {});
									d.refreshInfo[g] = {
										$icon : f.find(".ui-refresh-icon"),
										$label : f.find(".ui-refresh-label"),
										text : f.find(".ui-refresh-label")
												.html()
									}
								}
								f.on("click", function() {
											if (!e._status(g) || d._actDir) {
												return
											}
											e._setStyle(g, "loading");
											e._loadingAction(g, "click")
										})
							}
						})
			});
			e.on("destroy", function() {
						e.$el.remove()
					})
		},
		_create : function() {
			var f = this, e = f._options, d = f.$el;
			if (f._options.setup) {
				e.$upElem = d.find(".ui-refresh-up");
				e.$downElem = d.find(".ui-refresh-down");
				d.addClass("ui-refresh")
			}
		},
		_createBtn : function(d) {
			this._options["$" + d + "Elem"]
					.html('<span class="ui-refresh-icon"></span><span class="ui-refresh-label">&nbsp;</span>');
			return this
		},
		_setStyle : function(e, g) {
			var f = this, d = a.Event("statechange");
			f.trigger(d, f._options["$" + e + "Elem"], g, e);
			if (d.defaultPrevented) {
				return f
			}
			return f._changeStyle(e, g)
		},
		_changeStyle : function(d, g) {
			var e = this._options, f = e.refreshInfo[d];
			switch (g) {
				case "loaded" :
					f["$label"].html(f.text);
					f["$icon"].removeClass();
					e._actDir = "";
					break;
				case "loading" :
					f["$label"].html("\u52a0\u8f7d\u4e2d...");
					f["$icon"].addClass("ui-loading");
					e._actDir = d;
					break;
				case "disable" :
					f["$label"]
							.html("\u6ca1\u6709\u66f4\u591a\u5185\u5bb9\u4e86");
					break
			}
			return this
		},
		_loadingAction : function(d, e) {
			var g = this, f = g._options, h = f.load;
			a.isFunction(h) && h.call(g, d, e);
			g._status(d, false);
			return g
		},
		afterDataLoading : function(d) {
			var e = this, d = d || e._options._actDir;
			e._setStyle(d, "loaded");
			e._status(d, true);
			return e
		},
		_status : function(e, d) {
			var f = this._options;
			return d === c ? f["_" + e + "Open"] : f["_" + e + "Open"] = !!d
		},
		_setable : function(e, d, f) {
			var h = this, g = h._options, i = d ? [d] : ["up", "down"];
			a.each(i, function(l, k) {
						var j = g["$" + k + "Elem"];
						if (!j.length) {
							return
						}
						e ? j.show() : (f ? j.hide() : h
								._setStyle(k, "disable"));
						h._status(k, e)
					});
			return h
		},
		disable : function(d, e) {
			return this._setable(false, d, e)
		},
		enable : function(d) {
			return this._setable(true, d)
		}
	})
})(gmu, gmu.$);