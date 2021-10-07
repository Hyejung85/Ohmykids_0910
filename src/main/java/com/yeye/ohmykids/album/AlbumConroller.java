package com.yeye.ohmykids.album;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yeye.ohmykids.album.bo.AlbumBO;
import com.yeye.ohmykids.album.model.Album;
import com.yeye.ohmykids.album.model.AlbumWithComment;
import com.yeye.ohmykids.imagefile.bo.ImageFileBO;
import com.yeye.ohmykids.imagefile.model.ImageFile;
import com.yeye.ohmykids.user.kidsinfo.bo.KidsInfoBO;
import com.yeye.ohmykids.user.kidsinfo.model.KidsInfo;

@Controller
@RequestMapping("/album")
public class AlbumConroller {
	
	@Autowired
	private KidsInfoBO kidsInfoBO;
	
	@Autowired
	private AlbumBO albumBO;
	
	@Autowired
	private ImageFileBO imageFileBO;
	
	//앨범 작성 화면
	@RequestMapping("/create_view")
	public String createView(Model model
			, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		//kidsInfoList 보여주기
		List<KidsInfo> kidsInfoList = kidsInfoBO.getKidsInfoList(userId);
		model.addAttribute("kidsInfoList", kidsInfoList);
		
		return "album/create";
	}
	
	//앨범 목록
	@RequestMapping("/list_view")
	public String listView(
			Model model
			, HttpServletRequest request) {
		
			HttpSession session = request.getSession();
			int userId = (Integer)session.getAttribute("userId");
			
			//kidsInfoList 보여주기
			List<KidsInfo> kidsInfoList = kidsInfoBO.getKidsInfoList(userId);
			model.addAttribute("kidsInfoList", kidsInfoList);
			
			//albumList
			List<Album> albumList = albumBO.getAlbumList();			
			model.addAttribute("albumList", albumList);
			
			
			for(Album album : albumList) {
				//imageFileList
				List<ImageFile> imageFileList = imageFileBO.getImageFileList(album.getId(),album.getType());
				model.addAttribute("imageFileList", imageFileList);
			}
			
		return "album/list";
	}
	
	//앨범 상세, 수정 화면
		@RequestMapping("/detail_view")
		public String detailView(
				@RequestParam("id") int id
				, @RequestParam("type") String type
				, Model model
				, HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			int userId = (Integer)session.getAttribute("userId");
			
			//kidsInfoList 보여주기
			List<KidsInfo> kidsInfoList = kidsInfoBO.getKidsInfoList(userId);
			model.addAttribute("kidsInfoList", kidsInfoList);
			
			//album + comment
			List<AlbumWithComment> albumDetailList = albumBO.getAlbum(id, userId);
			model.addAttribute("albumDetailList", albumDetailList);
			
			//imageFileList
			List<ImageFile> imageFileList = imageFileBO.getImageFileList(id, type);
			model.addAttribute("imageFileList", imageFileList);
			
			return "album/detail";
		}
		

}
