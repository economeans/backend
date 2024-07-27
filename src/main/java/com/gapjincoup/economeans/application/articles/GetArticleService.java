package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.dtos.ArticleDetailResponseDto;
import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import com.gapjincoup.economeans.models.Article;
import com.gapjincoup.economeans.models.ArticleId;
import com.gapjincoup.economeans.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArticleService {
    private final FinnhubClient finnhubClient;
    private final ArticleRepository articleRepository;

    public GetArticleService(FinnhubClient finnhubClient, ArticleRepository articleRepository) {
        this.finnhubClient = finnhubClient;
        this.articleRepository = articleRepository;
    }

    public List<FinnhubMarketNewsDto> getListArticle(String category) {
        return finnhubClient.getListNews(category);
    }

    public ArticleDetailResponseDto getArticleDetail(String articleId) {
        String title = "무리하게 몸집 불린 큐텐, 결국 부메랑으로";

        List<List<String>> list2Term = Arrays.asList(
                Arrays.asList("나스닥", "상장", "위해", "확장에", "몰두"),
                Arrays.asList("2년간", "티몬·위메프·인터파크"),
                Arrays.asList("올핸", "美", "위시·AK몰까지", "인수"),
                Arrays.asList("인터파크", "작년", "157억", "영업손실"),
                Arrays.asList("티몬·위메프", "완전자본잠식", "상태"),
                Arrays.asList("티몬·위메프", "정산", "지연", "사태는", "모기업", "큐텐의", "무리한", "확장과", "무관하지", "않다는", "지적이", "나온다.", "큐텐은", "티몬·위메프·인터파크쇼핑·위시·AK몰", "등", "5개", "회사를", "지난", "2년간", "잇따라", "인수했다.", "'자금력이", "부족한", "큐텐이", "무리하게", "몸집을", "불렸고,", "결국", "정산", "지연이라는", "부메랑을", "맞고", "있다'는", "것이", "업계의", "시각이다."),
                Arrays.asList("무리하게", "몸집", "불린", "큐텐,", "결국", "부메랑으로큐텐은", "G마켓", "창립자인", "구영배", "대표가", "2010년", "설립한", "회사다.", "구", "대표는", "2009년", "미국", "이베이에", "G마켓을", "매각한", "뒤", "싱가포르로", "건너가", "큐텐을", "세웠다.", "이후", "큐텐은", "인도네시아", "말레이시아", "등", "동남아시아", "시장을", "비롯해", "인도(샵클루즈),", "중국", "등에", "진출했다."),
                Arrays.asList("2022년부터는", "국내외", "플랫폼을", "공격적으로", "인수하기", "시작했다.", "구", "대표가", "G마켓을", "매각할", "때", "계약서에", "쓴", "'10년간", "겸업금지'", "조항이", "끝난", "후다.", "큐텐은", "2022년", "9월", "티몬을,", "지난해", "3월과", "4월", "인터파크쇼핑과", "위메프를", "각각", "사들였다.", "이때", "큐텐은", "'지분교환'을", "활용했다.", "티몬·위메프", "지분을", "큐텐이", "갖고,", "큐텐의", "자회사", "큐익스프레스가", "발행하는", "신주를", "받는", "방식이다."),
                Arrays.asList("각", "e커머스", "계열사의", "물량을", "바탕으로", "큐익스프레스의", "안정적인", "수익", "구조를", "구축하고,", "큐익스프레스를", "나스닥시장에", "상장하겠다는", "계획이었다.", "큐텐은", "지난해엔", "11번가의", "유력한", "인수", "후보로", "떠오를", "정도로", "공격적인", "확장을", "이어왔다."),
                Arrays.asList("큐텐은", "올해", "2월", "미국", "쇼핑", "플랫폼", "위시를", "1억7300만달러(약", "2300억원)에", "인수했다.", "테무·알리익스프레스·쉬인", "등", "중국", "쇼핑앱의", "미국", "상륙으로", "위시의", "사세가", "쪼그라들긴", "했지만,", "여전히", "세계", "200여", "개국에", "진출해", "있는", "만큼", "위시", "인수를", "발판", "삼아", "아시아를", "넘어", "북미·유럽으로", "나아가겠다는", "계획도", "밝혔다.", "3월에는", "애경그룹", "AK플라자와", "전략적", "제휴를", "맺고", "자회사", "인터파크커머스를", "통해", "온라인", "쇼핑몰인", "AK몰을", "약", "5억원에", "인수하기도", "했다."),
                Arrays.asList("업계에서는", "큐텐이", "'확장'에만", "몰두한", "나머지", "'내실", "다지기'를", "경시했다는", "지적이", "나온다.", "위메프의", "지난해", "매출은", "1385억원으로", "전년보다", "28%", "감소했다.", "같은", "기간", "영업손실은", "1025억원으로", "1년", "새", "500억원", "늘었다.", "인터파크쇼핑도", "작년", "157억원의", "영업손실을", "냈다."),
                Arrays.asList("심지어", "티몬과", "위메프는", "모두", "누적", "적자가", "커져", "'완전자본잠식'에", "빠졌다.", "2022년", "기준", "티몬의", "유동부채는", "7193억원,", "유동자산은", "1309억원으로", "당장", "현금화할", "수", "있는", "자산보다", "1년", "안에", "갚아야", "할", "빚이", "더", "많다.", "유동부채는", "전년", "대비", "22%", "증가했고,", "유동자산은", "22%", "줄었다."),
                Arrays.asList("티몬은", "올해", "4월", "마감이던", "감사보고서도", "아직", "제출하지", "않았다.", "이런", "상황에서", "셀러와", "소비자", "이탈이", "이어지면", "경영", "위기가", "악화할", "것이라는", "우려도", "나온다."),
                Arrays.asList("이선아", "기자", "suna@hankyung.com")
        );

        return new ArticleDetailResponseDto(
                articleId,
                title,
                list2Term
        );
    }
}
