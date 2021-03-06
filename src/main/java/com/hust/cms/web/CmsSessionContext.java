package com.hust.cms.web;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class CmsSessionContext {
    private static final Map<String, HttpSession> ctx = new HashMap<String, HttpSession>();

    private CmsSessionContext() {
    }

    public static void addSessoin(HttpSession session) {
        ctx.put(session.getId(), session);
    }

    public static void removeSession(HttpSession session) {
        ctx.remove(session.getId());
    }

    public static HttpSession getSession(String sessionId) {
        return ctx.get(sessionId);
    }
}
