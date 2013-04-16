package no.tine.starterkit.controller;

import java.io.UnsupportedEncodingException;

import net.sf.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin/cachemanager")
public class CacheManagerController {

    private static final Logger LOG = LoggerFactory.getLogger(CacheManagerController.class);

    @Autowired
    @Qualifier("appCacheManager")
    private CacheManager appCacheManager;

    @Autowired
    @Qualifier("decoratorsCacheManager")
    private EhCacheCacheManager decoratorCacheManager;


    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public ModelAndView clear() throws UnsupportedEncodingException {

        ModelAndView mav = new ModelAndView("cache-manager");
        appCacheManager.clearAll();
        for (String cacheName : decoratorCacheManager.getCacheNames()) {
            decoratorCacheManager.getCache(cacheName).clear();
        }
        mav.addObject("message", "Cache is cleared");
        LOG.info("Cache is cleared");
        return mav;
    }


}
