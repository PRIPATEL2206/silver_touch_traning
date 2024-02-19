

import javax.servlet.Filter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;

/**
 * Servlet Filter implementation class CompressionFilter
 */
public class CompressionFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CompressionFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        CompressionResponseWrapper wrappedResponse = new CompressionResponseWrapper(httpResponse);
        chain.doFilter(request, (ServletResponse) wrappedResponse);
        byte[] compressedContent = wrappedResponse.getCompressedContent();
        httpResponse.setHeader("Content-Encoding", "gzip");
        httpResponse.setContentLength(compressedContent.length);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(compressedContent);
        outputStream.flush();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private static class CompressionResponseWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream baos;
        private GZIPOutputStream gzipOutputStream;

        public CompressionResponseWrapper(HttpServletResponse response) {
            super(response);
            baos = new ByteArrayOutputStream();
        }

        public ServletOutputStream getOutputStream() throws IOException {
            if (gzipOutputStream == null) {
                gzipOutputStream = new GZIPOutputStream(baos);
            }
            return new GZIPServletOutputStream(gzipOutputStream);
        }

        public byte[] getCompressedContent() throws IOException {
            if (gzipOutputStream != null) {
                gzipOutputStream.finish();
                gzipOutputStream.close();
            }
            return baos.toByteArray();
        }
    }

    private static class GZIPServletOutputStream extends ServletOutputStream {
        private final GZIPOutputStream gzipOutputStream;

        public GZIPServletOutputStream(GZIPOutputStream gzipOutputStream) {
            this.gzipOutputStream = gzipOutputStream;
        }

        @Override
        public void write(int b) throws IOException {
            gzipOutputStream.write(b);
        }

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener arg0) {
			// TODO Auto-generated method stub
			
		}
    }

}
